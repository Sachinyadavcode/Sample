package com.CustomerManagement.controller;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;
import com.CustomerManagement.service.*;
import com.CustomerManagement.util.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/admin")
public class AdminController
{

	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminConverter converter;
	
	@PostMapping
	public AdminDTO saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	
	@PostMapping("/login")
	public String validate(@RequestBody Admin admin) throws ServletException
	{
		String jwtToken="";
		
		if(admin.getUserName()==null && admin.getPassword()==null && admin.getRole()==null)
		{
			throw new ServletException("Please fill the username, password and role.");
		}
		
		admin =adminService.login(admin.getUserName(), admin.getPassword());
		
		if(admin==null)
		{
			throw new ServletException("Admin details not found");
		}
		
		jwtToken=Jwts.builder().setSubject(admin.getUserName()).claim("roles", admin.getRole()).setIssuedAt(new Date()).
		signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		return jwtToken;
	}
	
}
