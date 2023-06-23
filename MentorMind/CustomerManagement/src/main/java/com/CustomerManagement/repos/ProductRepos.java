package com.CustomerManagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CustomerManagement.entity.Product;

import java.util.*;

//indicates that the interface is a repository component in the spring framework
@Repository
public interface ProductRepos extends JpaRepository<Product, Integer>
{
	
	//custom JPQL query with a LIKE operator to perform a case-insensitive search for movies whose names start with the provided parameter.
	@Query("from Product where lower(productName) like :p%")
	List<Product> getProductByName(@Param("p") String productName);
	
	//get list of movies by price
	List<Product> getProductByPrice( float price);
	
}

