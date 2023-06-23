package com.CustomerManagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CustomerManagement.entity.*;
import com.CustomerManagement.repos.*;
import com.CustomerManagement.service.*;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepos userRepository;
	
	@Override
	public User registerUser(User user)
	{
		userRepository.save(user);
		return user;
	}

	@Override
	public User login(String userName, String password) 
	{
		
		return userRepository.findByUserNameAndPassword(userName, password);
	}

}
