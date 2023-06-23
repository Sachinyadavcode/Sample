package com.CustomerManagement.dto;
import lombok.*;
import java.util.*;

import com.CustomerManagement.entity.Order;



@Data
public class CustomerDTO 
{
	
	//represents a list of tickets
	private List<Order> order;
	
	//represents the email address of the customer
	private String customerFeedback;
	
	//represents the name of the customer
	private String customerName;
	

}