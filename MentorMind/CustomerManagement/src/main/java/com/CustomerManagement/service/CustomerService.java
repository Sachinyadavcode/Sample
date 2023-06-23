package com.CustomerManagement.service;

import com.CustomerManagement.entity.*;
import com.CustomerManagement.dto.*;


public interface CustomerService 
{
	//get all the booking details by booking id
	Customer getCustomerDetailById(int customerId);
	
	//booking ticket 
	OrderDTO orderproduct(CustomerDTO customerDTO);
	
	//cancel the ticket through ticket id
	String cancelOrder(int id);
}