package com.springbootjwt.service;

import com.springbootjwt.model.OrderDetails;

public interface OrderDetailsService {
	String	placeOrder(int productId,long userId,OrderDetails orderDetails);
	String cancelOrder(int orderId);
}
