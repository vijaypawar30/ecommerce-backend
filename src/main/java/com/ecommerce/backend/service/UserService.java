package com.ecommerce.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.dto.AuthResponse;
import com.ecommerce.backend.dto.RegisterRequest;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.security.JwtUtil;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//Register
	public AuthResponse register(RegisterRequest request) {
		//Create new user
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		
		//Encrypt pass before saving!
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole("USER");
		
		//save user in database
		userRepository.save(user);
		
		//Generate JWT token
		String token = jwtUtil.generateToken(user.getEmail());
		
		//Return token
		return new AuthResponse(token);

	}
	
	public AuthResponse login(String email, String password) {
	    // Find user by email
	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found!"));

	    // Check password
	    if(!passwordEncoder.matches(password, user.getPassword())) {
	        throw new RuntimeException("Invalid password!");
	    }

	    // Generate JWT token
	    String token = jwtUtil.generateToken(user.getEmail());

	    // Return token
	    return new AuthResponse(token);
	}
}
