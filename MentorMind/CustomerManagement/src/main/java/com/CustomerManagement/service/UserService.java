package com.CustomerManagement.service;

import com.CustomerManagement.entity.*;

public interface UserService 
{

	User registerUser(User user);
	
	User login(String userName, String password);
}
