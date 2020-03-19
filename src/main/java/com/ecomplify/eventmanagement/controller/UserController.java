package com.ecomplify.eventmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecomplify.eventmanagement.models.entities.User;

@RestController
public class UserController {

	@GetMapping("/userauthentication/{emailId}/{password}")
	public ResponseEntity<User> UserAuthentication(@PathVariable String emailId,
			@PathVariable String password ){
		
		System.out.println("Just for the testing purpose ");
		
		return null;
		
	}
	
}
