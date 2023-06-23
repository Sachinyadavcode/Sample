package com.springbootjwt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//this class is used to generate products order detail ordered by an user
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@OneToOne
	//an single order details can hold single product detail
	private Product product;

	@OneToOne
	//a single order detail can holds single user detail
	private User user;
	
	@Column
	private double total;

	@Column
	@NotNull
	private int quantity;

	@Column
	private LocalDate orderDate=LocalDate.now();
	
	@Column(length=20, nullable=false)
	private String paymentMode;
	
	@NotNull
	@Column(length = 20)
	private String status;
}
