package com.CustomerManagement.serviceimpl;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;
import com.CustomerManagement.exception.ResourceNotFoundException;
import com.CustomerManagement.repos.*;
import com.CustomerManagement.service.*;
import com.CustomerManagement.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;

//indicates that it's a service component and can be automatically detected during component scanning
@Service
public class CustomerServiceImpl implements CustomerService
{
	
	//indicates that it is a dependency that will be automatically injected
	@Autowired
	private CustomerRepos customerRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	
	@Override
	
	//retrieves booking details based on a given booking ID
	public Customer getCustomerDetailById(int customerId) 
	{
		Optional<Customer> customer= Optional.ofNullable(customerRepository.findById(customerId).orElseThrow(()->
		new ResourceNotFoundException("Customer", "ID", customerId)));
		return customer.isPresent() ? customer.get() : null;
	}


	
	
	//books a ticket based on the provided BookingDTO object
	@Override
	public OrderDTO orderproduct(CustomerDTO customerDTO) {
		OrderDTO orderDTO= new OrderDTO();
		float amount= orderService.getOrderAmount(customerDTO.getOrder());
		if(amount!=0f)
			
		{
			
			// creates a new Customer object
			Feedback feedback= new Feedback(customerDTO.getCustomerName(), customerDTO.getCustomerFeedback());
			
			//checking if the customer already exists in the database using the CustomerService
			Integer customerIdFromDb = feedbackService.isFeedbackPresent(feedback);
			if(customerIdFromDb!=null)
			{
				feedback.setId(customerIdFromDb);
			}
			else
			{
				feedback= feedbackService.saveFeedback(feedback);
			}
			
			// a new Booking object is created with the customer and ticket details
			Customer customer=  new Customer(feedback,customerDTO.getOrder());
			
			//saved using the BookingRepository
			customer= customerRepository.save(customer);
			
			orderDTO.setAmount(amount);
			orderDTO.setDate(DateUtil.getCurrentDateTime());
			orderDTO.setInvoiceNumber(new Random().nextInt(1000));
			orderDTO.setCustomerId(customer.getId());
			orderDTO.setNotes("Thank you for ordering");
		}
		else
		{
			orderDTO.setNotes("Error - "+"Not Found");
		}
		return orderDTO;
	}
	
	@Override
	
	//cancels a ticket based on the provided ticket ID.
	public String cancelOrder(int id) 
	{
		String message=null;
		
		//retrieves the booking from the BookingRepository using the ID
		Customer customer= customerRepository.findById(id).get();
		if(customer!=null)
		{
			customerRepository.deleteById(id);
			message="Order Deleted";
		}
		else
		{
			message="Order Id not found";
		}
		return message;
	}


	
	}

