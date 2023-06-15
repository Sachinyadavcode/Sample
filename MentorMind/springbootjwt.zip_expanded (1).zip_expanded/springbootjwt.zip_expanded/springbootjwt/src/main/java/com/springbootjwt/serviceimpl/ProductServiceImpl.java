package com.springbootjwt.serviceimpl;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootjwt.exception.BadRequestException;
import com.springbootjwt.model.OrderDetails;
import com.springbootjwt.model.Product;
import com.springbootjwt.model.User;
import com.springbootjwt.repository.OrderDetailsRepository;
import com.springbootjwt.repository.UserRepository;
import com.springbootjwt.repository.productRepository;
import com.springbootjwt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private productRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public Product addProduct(Product product) {
	
		return productRepository.save(product);
	}
	
	@Override
	public List<Product> getAllproductsByName(String name) {
		List<Product> products=productRepository.getProductByName(name);
		
		return products;
	}

	@Override
	
	// Updates the details of a product with the given ID
	public Product updateProduct(int id, Product product) 
	{
		Product Product = productRepository.findById(id).orElseThrow(()->
		new BadRequestException("Product with this id not found"));
		Product.setName(product.getName());
		Product.setBrand(product.getBrand());
		Product.setStock(product.getStock());
		Product.setPrice(product.getPrice());
		
		productRepository.save(Product);
		return Product;
	}

	
	
	public String deleteProduct(int id) 
	{
		String message=null;
		
		//retrieves the booking from the productRepository using the ID
		Product products= productRepository.findById(id).get();
		if(products!=null)
		{
			productRepository.deleteById(id);
			message="Product Deleted Sucessfully";
		}
		else
		{
			message="Product Id not found";
		}
		return message;
	}
}
