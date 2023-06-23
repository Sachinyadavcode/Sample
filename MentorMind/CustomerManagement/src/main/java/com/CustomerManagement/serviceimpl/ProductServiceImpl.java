package com.CustomerManagement.serviceimpl;
import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;
import com.CustomerManagement.repos.*;
import com.CustomerManagement.service.*;
import com.CustomerManagement.util.*;
import com.CustomerManagement.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//indicates that it's a service component and can be automatically detected during component scanning
@Service
public class ProductServiceImpl implements ProductService
{

	//indicates that it is a dependency that will be automatically injected
	@Autowired
	private ProductRepos productRepository;
	
	@Autowired
	private ProductConverter productConverter;

	@Override
	
	// Saves a movie object to the product repository and returns a message indicating whether the product was added successfully
	public String createProduct(Product product) 
	{
		String message=null;
		productRepository.save(product);
		if(product!=null)
		{
			message="Product is added Successfully";
		}
		return message;
	}

	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	
	// Updates the details of a product with the given ID
	public ProductDTO updateProduct(int id, Product product) 
	{
		Product existingproduct = productRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Product", "ID", id));
		existingproduct.setProductName(product.getProductName());
		existingproduct.setPrice(product.getPrice());
		existingproduct.setQuantityAvailable(product.getQuantityAvailable());
		
		productRepository.save(existingproduct);
		
		
		//returns a ProductDTO (a data transfer object) representing the updated product
		return productConverter.convertToProductDTO(existingproduct);
	}

	@Override
	
	//Deletes a product with the specified ID from the repository
	public String deleteProductById(int id)
	{
		String message=null;
		Optional<Product> product= Optional.ofNullable(productRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Product", "ID", id)));
		if(product.isPresent())
		{
			productRepository.deleteById(id);
			message= "Product have been deleted";
		}
		else 
		{
			message= "Product details not found";
		}
		return message;
	}

	@Override
	
	// Retrieves a list of movies with the given name from the repository
	public List<ProductDTO> getProductByName(String productName) 
	{
		List<Product> product= productRepository.getProductByName(productName);
		List<ProductDTO> productDTO= new ArrayList<>();
		for(Product p: product)
		{
			productDTO.add(productConverter.convertToProductDTO(p));
		}
		return productDTO;
	}

	
	@Override
	
	//Retrieves a list of movies with the given price from the repository
	public List<ProductDTO> getProductByPrice(float moviePrice) 
	{
		List<Product> product= productRepository.getProductByPrice(moviePrice);
		List<ProductDTO> productDTO= new ArrayList<>();
		for(Product p: product)
		{
			productDTO.add(productConverter.convertToProductDTO(p));
		}
		return productDTO;
	}

}
	
