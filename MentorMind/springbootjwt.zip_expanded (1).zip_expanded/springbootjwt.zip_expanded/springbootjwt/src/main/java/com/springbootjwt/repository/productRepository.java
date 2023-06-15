package com.springbootjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbootjwt.model.Product;

//inherits a set of CRUD (Create, Read, Update, Delete) operations 

public interface productRepository extends JpaRepository<Product,Integer>
	{
		@Query("select p from Product p where p.name=?1")
		List<Product> getProductByName(String name);
	}
	