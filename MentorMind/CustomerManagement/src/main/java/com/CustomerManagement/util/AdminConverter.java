package com.CustomerManagement.util;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;

@Component
public class AdminConverter 
{

	//convert to product entity through productdto 
		public Admin convertToAdminEntity(AdminDTO adminDTO)
		{
			Admin admin= new Admin();
			if(adminDTO!=null)
			{
				
				//copies the properties of source object to target object with same property
				BeanUtils.copyProperties(adminDTO, admin);
			}
			return admin;
		}
		
		//convert to productdto through product
		public AdminDTO convertToAdminDTO(Admin admin)
		{
			AdminDTO adminDTO= new AdminDTO();
			if(admin!=null)
			{
				
				//copies the properties of source object to target object with same property
				BeanUtils.copyProperties(admin, adminDTO);
			}
			return adminDTO;
		}
}
