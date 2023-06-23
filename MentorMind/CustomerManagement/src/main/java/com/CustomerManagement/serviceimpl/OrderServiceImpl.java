package com.CustomerManagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.CustomerManagement.entity.*;
import com.CustomerManagement.repos.ProductRepos;
import com.CustomerManagement.service.*;
import org.springframework.stereotype.Service;


//indicates that it's a service component and can be automatically detected during component scanning
@Service
public class OrderServiceImpl implements OrderService
{
	
		//indicates that it is a dependency that will be automatically injected into the AmoutServiceImpl class
		@Autowired
		private ProductRepos productRepository;
		
		@Override
		public float getOrderAmount(List<Order> OrderList)
		{
		
			//store the cumulative ticket amount
			float totalOrderAmount = 0f;
			
			//store the amount for each individual ticket
	        float singleOrderAmount = 0f;
	        
	        //track the number of available seats after each ticket purchase
	        int quantityAvailable = 0;
		
	        for(Order t : OrderList)
	        {
	        	int productId= t.getProductId();
	        	Optional<Product> product= productRepository.findById(productId);
	        	
	        	//proceeds to calculate the ticket amount
	        	if(product.isPresent())
	        	{
	        		Product product1= product.get();
	        		if(product1.getQuantityAvailable() < t.getQuantity())
	        		{
	        			singleOrderAmount= product1.getPrice() * product1.getQuantityAvailable();
	        			t.setQuantity(product1.getQuantityAvailable());
	        		}
	        		else
	        		{
	        			singleOrderAmount= t.getQuantity() * product1.getPrice();
	        			quantityAvailable=product1.getQuantityAvailable() - t.getQuantity();
	        		}
	        		totalOrderAmount= totalOrderAmount + singleOrderAmount;
	        		product1.setQuantityAvailable(quantityAvailable);
	        		
	        		// set back to 0 to prepare for the next iteration
	        		quantityAvailable=0;
	        		t.setProductname(product1.getProductName());
	        		t.setTotalAmount(singleOrderAmount);
	        		productRepository.save(product1);
	        	}
	        }
	        //returns the totalTicketAmount calculated for all the tickets
	        return totalOrderAmount;
		}

}
