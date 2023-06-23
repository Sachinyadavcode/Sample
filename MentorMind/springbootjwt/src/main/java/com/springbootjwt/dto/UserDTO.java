package com.springbootjwt.dto;


import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springbootjwt.model.Role;

import lombok.Data;

@Data
public class UserDTO 
{
	@NotNull(message="User_name cannot be null")
	@NotBlank(message="User_name is required")
	@Pattern(regexp = "^[a-zA-Z]{2,20}$", message="Please enter proper user_name")
    @Size(max=20, message = "maximum 20 characters allowed")
	@Size(min=2, message="User_name should atleast be 2 characters")
	private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max=20, message = "maximum 20 characters allowed")
    private String emailAddress;

    @NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{8,15}$", message="Please enter proper password format")
    @Size(min = 8,max=15, message = "Password must be at least 8 to 15 characters long")
    private String password;

    @Size(max=30, message = "maximum 30 characters")
    @NotBlank(message = "Address is required")
    private String address;
    
    private Role role;
}
