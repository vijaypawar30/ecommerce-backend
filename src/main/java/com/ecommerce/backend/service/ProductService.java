package com.ecommerce.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return productRepository.findById(id).orElse(null);
	}
	
	//Add new product
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	//Update product
	public Product updateProduct(Long id, Product product) {
		product.setId(id);
		return productRepository.save(product);
	}
	
	//Delete product
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
