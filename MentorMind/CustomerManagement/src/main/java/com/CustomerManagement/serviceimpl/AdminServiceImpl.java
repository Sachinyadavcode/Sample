package com.CustomerManagement.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;
import com.CustomerManagement.repos.*;
import com.CustomerManagement.service.*;
import com.CustomerManagement.util.AdminConverter;
//indicates that it's a service component and can be automatically detected during component scanning
@Service
public class AdminServiceImpl implements AdminService
{

	//indicates that it is a dependency that will be automatically injected
	@Autowired
	AdminRepository adminRepository;
	
	//indicates that it is a dependency that will be automatically injected
	@Autowired
	AdminConverter converter;
	
	@Override
	
	//save admin
	public AdminDTO saveAdmin(Admin admin)
	{
		adminRepository.save(admin);
		return converter.convertToAdminDTO(admin);
	}

	@Override
	
	//login as admin
	public Admin login(String userName, String password) 
	{
		return adminRepository.findByUserNameAndPassword(userName, password);
		
	}

}
