package com.CustomerManagement.service;
import java.util.List;

import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;

public interface ProductService 
{//method to create Product
	String createProduct(Product Product);
	
	//get the list of all Products
	List<Product> getAllProducts();
	
	//update the Product through id
	ProductDTO updateProduct(int id, Product Product);
	
	//delete Product through id
	String deleteProductById(int id);
	
	//get Product by Productname
	List<ProductDTO> getProductByName(String ProductName);
	
	//get list of Product by price
	List<ProductDTO> getProductByPrice(float ProductPrice);
	
	//List<ProductDTO> getProductBYPriceBetween(float startPrice, float endPrice);
}
