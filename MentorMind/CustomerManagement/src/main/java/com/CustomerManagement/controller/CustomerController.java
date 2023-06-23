package com.CustomerManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.CustomerManagement.service.*;
import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;

//indicates that this class is a controller that handles RESTful API requests
@RestController

//specifies that this controller handles requests with the base URL path "/customer"
@RequestMapping("/api/customer")
public class CustomerController 
{
	
	//automatic dependency injection
	@Autowired
	private CustomerService customerService;
	
	//retrieves customer details by calling the getcustomerDetailById method of the customerService 
	@GetMapping("/{id}") 
	public Customer getcustomerDetails(@PathVariable int customerId)
	{
		Customer customer= customerService.getCustomerDetailById(customerId);
		
		//returns the customer object
		return customer;
	}
	
	@PostMapping("/orderproduct")
	
	//calls the bookTicket method of the customerService
	public OrderDTO orderproduct(@RequestBody CustomerDTO customerDTO)
	{
		
		// returns the resulting TicketDTO object.
		return customerService.orderproduct(customerDTO);
	}
		
	@DeleteMapping("/{id}")
	
	//calls the cancelTicket method of the customerService  
	public String cancelOrder(@PathVariable("id") int id)
	{
		
		//returns the cancellation status
		return customerService.cancelOrder(id);
	}

}
