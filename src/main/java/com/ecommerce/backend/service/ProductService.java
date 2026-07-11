package com.ecommerce.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.exception.ResourceNotFoundException;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	//Get all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	//Get product by ID
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Product not found with id:" + id));
	}
	
	//Add new product
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	//Update product
	public Product updateProduct(Long id, Product product) {
		//Check if product exists or not
		productRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Product not found with id:" + id));
		product.setId(id);
		return productRepository.save(product);
	}
	
	//Delete product
	public void deleteProduct(Long id) {
		productRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(
				"Product not found with id:" + id));
		productRepository.deleteById(id);
	}
}
