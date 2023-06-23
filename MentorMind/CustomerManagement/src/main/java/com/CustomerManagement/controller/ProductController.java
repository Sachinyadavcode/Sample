package com.CustomerManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;
import com.CustomerManagement.service.*;
import com.CustomerManagement.util.*;

//indicates that this class is a controller that handles RESTful API requests
@RestController
@RequestMapping("/api")
public class ProductController 
{
	
	//automatic dependency injection
	@Autowired
	private ProductService productService;
	
	//automatic dependency injection.
	@Autowired
	private ProductConverter productConverter;
	
	// POST request to add a Product
	@PostMapping("/addProduct")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO)
	{
		
		// converts the ProductDTO to a Product entity using the ProductConverter
		final Product product= productConverter.convertToProductEntity(productDTO);
		
		
			//calls the createProduct method from the ProductService
			productService.createProduct(product);
			return new ResponseEntity<String>("Product is added Successfully", 
					HttpStatus.CREATED);
	}
	
	
	//Handles the GET request to retrieve all Products
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	//Handles the PUT request to update a Product
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO)
		{
			Product product1= productConverter.convertToProductEntity(productDTO);
			return new ResponseEntity<ProductDTO>(productService.updateProduct(id, product1), HttpStatus.OK);
		}
		
	
	// Handles the DELETE request to delete a Product
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable ("id") int id)
	{
			
				return new ResponseEntity<String>(productService.deleteProductById(id), HttpStatus.OK);
	}
	// Handles the GET request to retrieve Products by price
	@GetMapping("/getProductByPrice/{price}")
	public List<ProductDTO> getProductByPrice(@PathVariable("price") float productPrice)
	{
		return productService.getProductByPrice(productPrice);
	}
	
}
