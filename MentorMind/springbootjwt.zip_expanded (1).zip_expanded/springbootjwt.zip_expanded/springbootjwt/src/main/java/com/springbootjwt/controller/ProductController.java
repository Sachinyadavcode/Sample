 

package com.springbootjwt.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjwt.dto.ResponseDTO;
import com.springbootjwt.model.OrderDetails;
import com.springbootjwt.model.Product;
import com.springbootjwt.model.User;
import com.springbootjwt.service.ProductService;
import com.springbootjwt.serviceimpl.ProductServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

    private final Logger logger= 
   	LoggerFactory.getLogger(ProductController.class);
 
	User user=new User();
    @PostMapping("/admin/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
    	
    	return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
    	
    }
  
    
  
    @GetMapping("/productsByName/{name}")
    public List<Product> getAllProductsByName(@PathVariable("name") String name)
    {
    	return  productService.getAllproductsByName(name);
    }
  
    @PutMapping("product/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) 
    {
    	return productService.updateProduct(id, product);
    }
    
    
    @DeleteMapping("product/{id}")
	
	//calls the deleteProduct method of the productService  
	public String deleteProduct(@PathVariable("id") int id)
	{
		
		//returns the cancellation status
		return productService.deleteProduct(id);
	}
}

