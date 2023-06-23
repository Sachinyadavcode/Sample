package com.springbootjwt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.springbootjwt.filter.JwtTokenFilter;

/*
 SecurityFilterChain bean, 
 define a lot of configurations such as the
 session creation policy as stateless, and also
 disable cors and csrf. Also, add configuration to 
 expose the UserController API endpoint as public. 
 And secured other API endpoints
 */

//indicates that the class has @Bean definition methods
@Configuration

//enable web securities
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration
{
	//@Autowired used for automatic dependency injection
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    //indicates that a method produces a bean to be managed by the Spring container
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception 
    {
    	//configuring web based security for specific http requests
        httpSecurity = httpSecurity.cors().and().csrf().disable();
        httpSecurity=httpSecurity.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
       
        httpSecurity.authorizeRequests()
        .antMatchers("/").hasAnyAuthority("guest","admin")
        .antMatchers("/admin/*").hasAnyAuthority("admin")
        .antMatchers("/api/**").hasAnyAuthority("guest")
        .antMatchers("/update/**").hasAnyAuthority("admin")
        .antMatchers("/delete/**").hasAuthority("admin")
        .anyRequest().permitAll();
        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}

