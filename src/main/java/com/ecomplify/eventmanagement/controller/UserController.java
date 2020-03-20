package com.ecomplify.eventmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecomplify.eventmanagement.models.entities.User;
import com.ecomplify.eventmanagement.services.ApplicationBusinessService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {


	@Autowired
	ApplicationBusinessService applicationbusinesssrvc;

	@GetMapping("/userauthentication/{emailId}/{password}")
	public ResponseEntity<User> UserAuthentication(@PathVariable String emailId,
			@PathVariable String password ){
		
	applicationbusinesssrvc.checkAuthentication(emailId,password);

		return null;
		
	}
	
}
