package com.CustomerManagement.service;
import java.util.List;

import com.CustomerManagement.entity.Order;

public interface OrderService
{
	
	//a float representing the method getticketamount through list of tickets
	float getOrderAmount(List<Order> orderList);

	
}