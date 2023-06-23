package com.CustomerManagement.dto;

import lombok.Data;

@Data
public class ProductDTO
{
	//an integer represents the id for the movie
	private int productId;
	
	//a string represents the moviename
	private String productName;
	
	//an integer represents the seats which are available
	private int quantityAvailable;
	
	//a float represents the price
	private float price;

}
