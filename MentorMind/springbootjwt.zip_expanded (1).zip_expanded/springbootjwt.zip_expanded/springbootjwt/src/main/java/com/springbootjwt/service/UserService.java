
package com.springbootjwt.service;

import java.util.List;

import com.springbootjwt.dto.LoginDTO;
import com.springbootjwt.dto.UserDTO;
import com.springbootjwt.model.User;

public interface UserService
{
	  //for user registration
	  void registerUser(UserDTO userDTO);
	  
	  //for user login
	  String login(LoginDTO loginDTO);
}

