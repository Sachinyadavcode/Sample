
package com.springbootjwt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springbootjwt.exception.*;
import com.springbootjwt.dto.LoginDTO;
import com.springbootjwt.dto.UserDTO;
import com.springbootjwt.model.Role;
import com.springbootjwt.model.User;
import com.springbootjwt.repository.RoleRepository;
import com.springbootjwt.repository.UserRepository;
import com.springbootjwt.service.UserService;
import com.springbootjwt.util.JwtUtil;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    //creating method for user register
    @Override
    public void registerUser(UserDTO userDTO) 
    {
    	Role role=roleRepository.findById(2l).get();
    	
      User user=User.builder()
      				.name(userDTO.getName())
        			.address(userDTO.getAddress())
                	.emailAddress(userDTO.getEmailAddress())
                    .role(role)
                    .password(passwordEncoder.encode
                    		(userDTO.getPassword()))
                	.build();
        userRepository.save(user);
    }

    //creating method for login
    @Override
    public String login(LoginDTO loginDTO) 
    {
        Optional<User> userOptional=
        	userRepository.findByEmailAddress
            	(loginDTO.getEmailAddress());
        
        if(userOptional.isEmpty())
        {
            throw new BadRequestException("User Not Found.");
        }
        if(passwordEncoder.matches
        	(loginDTO.getPassword(),
            userOptional.get().getPassword())
          )
        {
            return jwtUtil.generateAccessToken
            		(userOptional.get());
        }
        else
        {
           throw new BadRequestException("Invalid UserName Or Password");
        }
    }
}
