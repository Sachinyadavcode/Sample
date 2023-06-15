package com.springbootjwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	
	@NotNull
	@Column(length = 25)	
	private String name;
	
	@NotNull
	@Column(length = 25)
	private String brand;

	@NotNull
	private int stock;

	@NotNull
	private double price;
	
}
