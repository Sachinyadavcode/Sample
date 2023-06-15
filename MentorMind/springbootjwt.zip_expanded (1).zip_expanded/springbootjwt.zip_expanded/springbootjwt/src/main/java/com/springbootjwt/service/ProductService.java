package com.springbootjwt.service;

import java.util.List;

import com.springbootjwt.model.OrderDetails;
import com.springbootjwt.model.Product;

public interface ProductService 
	{
		Product addProduct(Product product);
		List<Product> getAllproductsByName(String name);
		String  deleteProduct(int id);
		Product updateProduct(int id, Product product);
	}
