package com.ecommerce.backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.dto.OrderItemRequest;
import com.ecommerce.backend.dto.OrderRequest;
import com.ecommerce.backend.exception.ResourceNotFoundException;
import com.ecommerce.backend.model.Order;
import com.ecommerce.backend.model.OrderItem;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.OrderRepository;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.repository.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	//Place new order
	public Order placeOrder(OrderRequest request) {
		
		//Find user
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"User not found with id: "+ request.getUserId()));
		
		//create new order
		Order order = new Order();
		order.setUser(user);
		order.setStatus("PENDING");
		order.setOrderDate(LocalDateTime.now());
		
		//Create order items
		List<OrderItem> orderItems = new ArrayList<>();
		double totalAmount = 0;
		
		for(OrderItemRequest itemRequest : request.getOrderItems()) {
			//Find product
			Product product = productRepository.findById(itemRequest.getProductId())
					.orElseThrow(() -> new ResourceNotFoundException(
							"Product not found with id: "+ itemRequest.getProductId()));
			
			//Create order item
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(itemRequest.getQuantity());
			orderItem.setPrice(product.getPrice() * itemRequest.getQuantity());
			orderItem.setOrder(order);
			
			orderItems.add(orderItem);
			totalAmount += orderItem.getPrice();
		}
		
		order.setOrderItems(orderItems);
		order.setTotalAmount(totalAmount);
		
		return orderRepository.save(order);
	}
	
	
	
	//Get all orders
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	//Get orders by user
	public List<Order> getOrderByUser(Long userId){
		return orderRepository.findByUserId(userId);
	}
	
	//Update order status
	public Order updateOrderStatus(Long id, String status) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Order not found with id: "+ id));
		order.setStatus(status);
		return orderRepository.save(order);
	}
	
	//Cancel order
	public void cancelOrder(Long id) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Order not found with id: "+ id));
		orderRepository.deleteById(id);
	}

}
