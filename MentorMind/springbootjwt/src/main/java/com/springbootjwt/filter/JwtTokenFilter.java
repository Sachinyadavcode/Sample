package com.springbootjwt.filter;



import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.util.*;
import com.springbootjwt.dto.*;
import com.springbootjwt.util.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

//allows spring to detect custom beans automatically
@Component
public class JwtTokenFilter extends OncePerRequestFilter 
{
	//used for automatic dependency injection
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void 
    	doFilterInternal
    	(
        	HttpServletRequest request,
        	HttpServletResponse response,
			FilterChain filterChain
         )  throws ServletException, IOException 
     {      
    	final String header = request.getHeader(HttpHeaders.AUTHORIZATION);        
            if (header==null || !header.startsWith("Bearer ")) 
            {
            	//allows the filter to pass on the request & response to the next entity in the chain
                filterChain.doFilter(request, response);
                return;
            }
            final String token = header.split(" ")[1].trim();
            if (!jwtUtil.validate(token))
            {
            	//allows the filter to pass on the request & response to the next entity in the chain
                filterChain.doFilter(request, response);
                return;
            }
            JwtTokenDTO jwtTokenDTO=jwtUtil.getJwtTokenDTO(token);
            
            //authority granted to an authentication object
            List<GrantedAuthority> grantedAuthorityList=new ArrayList<>();
            grantedAuthorityList.add(new SimpleGrantedAuthority(jwtTokenDTO.getRole()));
            Principal principal=new Principal();
            principal.setToken(token);
            principal.setEmailAddress(jwtTokenDTO.getSubject());
            principal.setRole(jwtTokenDTO.getRole());
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken
                (principal,null,grantedAuthorityList);       
            SecurityContextHolder.getContext()
            	.setAuthentication(authenticationToken);
            filterChain.doFilter(request,response);
        }
    }
