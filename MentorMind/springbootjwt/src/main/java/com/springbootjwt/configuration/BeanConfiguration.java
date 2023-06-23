package com.springbootjwt.configuration;
//PasswordEncoder bean that will be used to encrypt passwords 
//that we store in the database.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//indicates that the class has @Bean definition methods
@Configuration
public class BeanConfiguration 
{
	//indicates that a method produces a bean to be managed by the Spring container
    @Bean
    public PasswordEncoder passwordEncoder()
    {
    	//encrypting password using BcryptHasing algorithm
        return new BCryptPasswordEncoder();
    }
}