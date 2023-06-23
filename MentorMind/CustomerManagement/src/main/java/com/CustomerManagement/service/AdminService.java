package com.CustomerManagement.service;
import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;

public interface AdminService {

	AdminDTO saveAdmin(Admin admin);
	Admin login(String userName, String password);
}
