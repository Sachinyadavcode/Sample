package com.CustomerManagement.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer
{
	//specifies primary key
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  	
	//One customer can make many booking at a time 
  	@ManyToOne(cascade = CascadeType.MERGE)
  	
  	//to prevent the customer field from being serialized to JSON
  	@JsonIgnore
  	private Feedback feedback;
  	
  	//One booking with multiple tickets
  	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Order.class)
  	@JoinColumn(name = "customer_id", referencedColumnName = "id")
  	private List<Order> customer;
  	
  	//Parameterized constructor	
	public Customer(Feedback feedback, List<Order> customer) 
	{
		super();
		this.feedback = feedback;
		this.customer = customer;
	}			

}
