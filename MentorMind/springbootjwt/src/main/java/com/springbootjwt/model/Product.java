package com.springbootjwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//entity class takes all the product details for adding into the system by an admin
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(length = 25,name="product_type")
	@Pattern(regexp="^[a-zA-Z]{2,25}$", message="Product type should only consist of charactes")
	private String productType;
	
	@NotNull
	@Column(length = 50,name="product_model")
	private String name;

	@NotNull
	private int stock;

	@NotNull
	private double price;
	
	@Column(length= 25)
	@JsonIgnoreProperties
	private String status;
}
