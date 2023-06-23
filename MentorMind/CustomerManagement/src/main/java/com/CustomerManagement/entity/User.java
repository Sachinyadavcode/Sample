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

//this class is used to register the user to book tickets
public class User 
{
	
	//Specifies the primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//string representing the name of the user
	@Column(length = 30, nullable = false)
	private String userName;
	
	//string representing the password of the user
	@Column(length = 30,nullable = false)
	private String password;
	
	//string representing the role of the user
	@Column(length = 30,nullable = false)
	private String email;
}

