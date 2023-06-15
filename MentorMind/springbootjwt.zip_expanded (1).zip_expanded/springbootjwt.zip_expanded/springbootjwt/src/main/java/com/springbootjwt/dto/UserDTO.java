package com.springbootjwt.dto;


import com.springbootjwt.model.Role;

import lombok.Data;

@Data
public class UserDTO 
{
	private String name;

    private String emailAddress;

    private String password;

    private String address;

    private Role role;
}
