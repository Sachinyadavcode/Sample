package com.springbootjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjwt.model.OrderDetails;

//inherits a set of CRUD (Create, Read, Update, Delete) operations 
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>
{

}
