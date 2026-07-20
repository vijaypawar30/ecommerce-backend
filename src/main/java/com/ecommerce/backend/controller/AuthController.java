package com.ecommerce.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.AuthResponse;
import com.ecommerce.backend.dto.LoginRequest;
import com.ecommerce.backend.dto.RegisterRequest;
import com.ecommerce.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public AuthResponse register(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	
	//Login
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {
		return userService.login(request.getEmail(), request.getPassword());
	}

}
