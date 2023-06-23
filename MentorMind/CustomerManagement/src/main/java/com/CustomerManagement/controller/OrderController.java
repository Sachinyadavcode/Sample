//package com.CustomerManagement.controller;
//import com.CustomerManagement.service.*;
//import com.CustomerManagement.entity.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/order")
//public class OrderController 
//{
//	@Autowired
//	private OrderService orderservice;
//	
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping
//	public Order create(@RequestBody Order order) {
//		return orderservice.save(order);
//	}
//	
//	@ResponseStatus(HttpStatus.OK)
//	@GetMapping
//	public List<Order> read(){
//		return orderservice.getAllOrder();
//	}
//	
//	@ResponseStatus(HttpStatus.OK)
//	@GetMapping("/{id}")
//	public Order read(@PathVariable Long id) {
//		return orderservice.getOrderById(id);
//	}
//	
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Long id) {
//		orderservice.delete(id);
//	}
//	
//	public Order update(@PathVariable Long id,@RequestBody Order order) {
//		return orderservice.update(order, id);
//	}
//	
//
//}
