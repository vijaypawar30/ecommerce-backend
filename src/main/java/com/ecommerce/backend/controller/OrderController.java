package com.ecommerce.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.OrderRequest;
import com.ecommerce.backend.model.Order;
import com.ecommerce.backend.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final AuthController authController;
	
	@Autowired
	OrderService orderService;

    OrderController(AuthController authController) {
        this.authController = authController;
    }
	
	//Place new order
    @PostMapping
	public Order placeOrder(@RequestBody OrderRequest request) {
		return orderService.placeOrder(request);
	}
	
	//Get all orders
    @GetMapping
    public List<Order> getAllOrders(){
    	return orderService.getAllOrders();
    }
	
    //Get orders by user
    @GetMapping("/user/{userId}")
    public List<Order> getOrderByUser(@PathVariable Long userId) {
    	return orderService.getOrderByUser(userId);
    }
    
    //Update order status
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
    	return orderService.updateOrderStatus(id, status);
    }
    
    //Cancel order
    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable Long id) {
    	orderService.cancelOrder(id);
    	return "Order cancelled successfully !";
    }
}
