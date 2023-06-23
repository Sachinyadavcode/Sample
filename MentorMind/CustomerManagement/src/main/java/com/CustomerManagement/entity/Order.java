package com.CustomerManagement.entity;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="customer_order")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	//integer representing the id of the movie
	@Column(name="product_id")
	private int productId;
	
	//string representing the name of the movie
	@Column(name="product_name")
	private String productname;
	
	//integer representing the booked_seats of the movie
	@Column(name="quantiy")
	private int quantity;
	
	//float representing the total_amount of the movie
	@Column(name="total_amount")
	private float totalAmount;

	public Order(int productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public Order(int productId, String productname, int quantity, float totalAmount) {
		this.productId = productId;
		this.productname = productname;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	
	
	//parameterized constructor
	
}
