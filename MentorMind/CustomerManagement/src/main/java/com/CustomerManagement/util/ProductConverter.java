package com.CustomerManagement.util;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CustomerManagement.dto.*;
import com.CustomerManagement.entity.*;
//used to mark a class as a Spring component
@Component
public class ProductConverter
{
	
	//convert to Product entity through Productdto 
	public Product convertToProductEntity(ProductDTO ProductDTO)
	{
		Product Product= new Product();
		if(Product!=null)
		{
			
			//copies the properties of source object to target object with same property
			BeanUtils.copyProperties(ProductDTO, Product);
		}
		return Product;
	}
	
	//convert to Productdto through Product
	public ProductDTO convertToProductDTO(Product Product)
	{
		ProductDTO ProductDTO= new ProductDTO();
		if(ProductDTO!=null)
		{
			
			//copies the properties of source object to target object with same property
			BeanUtils.copyProperties(Product, ProductDTO);
		}
		return ProductDTO;
	}

}
