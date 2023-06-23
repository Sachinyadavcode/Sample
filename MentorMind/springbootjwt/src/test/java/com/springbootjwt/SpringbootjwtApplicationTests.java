package com.springbootjwt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbootjwt.dto.UserDTO;
import com.springbootjwt.model.Product;
import com.springbootjwt.model.User;
import com.springbootjwt.repository.UserRepository;
import com.springbootjwt.repository.productRepository;
import com.springbootjwt.service.ProductService;
import com.springbootjwt.service.UserService;

@SpringBootTest
class SpringbootjwtApplicationTests
{
	//used for automatic dependency injection
	@Autowired
	private ProductService productService;
	
	//to add mock objects to the spring application context
	@MockBean
	private productRepository productRepository;
	
	@Test
	@DisplayName("Testing add Product Method")
	void testSaveProduct()
	{
		Product prod=Product.builder().productType("Mobile").name("Samsung-F13").stock(45).price(15000.0).build();
		//mock to return product value
		Mockito.when(productRepository.save(prod)).thenReturn(prod);
		//to check the product values matches the expected value
		assertThat(productService.addProduct(prod).getName()).isEqualTo("Mobile");
	}	
	
	@Test
	@DisplayName("Negative TestCase for add Product Method")
	void negativeTestSaveProduct()
	{
		Product prod=Product.builder().productType("Mobile").name("Samsung-F13").stock(45).price(15000.0).build();
		//mock to return product value
		Mockito.when(productRepository.save(prod)).thenReturn(prod);
		//to check the product values matches the expected value
		assertThat(productService.addProduct(prod).getName()).isEqualTo("laptop");
	}
}
