package com.CustomerManagement.entity;
import lombok.*;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="product_details")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	//string representing the name of the movie
	@Column(name="product_name", nullable = false, length = 20)
	private String productName;
	
	//integer representing the seat_available of the movie
	@Column(name="quantity_available", nullable = false, length = 3)
	private int quantityAvailable;
	
	//float representing the movie_price of the movie
	@Column(name="product_price", nullable = false, length = 3)
	private float price;	

}
