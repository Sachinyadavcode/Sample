package com.CustomerManagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin 
{
	//specifies the primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//string representing the username of admin
	@Column(length = 30, nullable = false)
	private String userName;
	
	////string representing the password for the admin
	@Column(length = 30,nullable = false)
	private String password;
	
	//string representing the role of the admin
	@Column(length = 30,nullable = false)
	private String role;
}
