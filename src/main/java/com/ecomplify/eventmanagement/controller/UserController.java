package com.ecomplify.eventmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecomplify.eventmanagement.exceptions.BusinessException;
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

	try {
		
		return new ResponseEntity<>(applicationbusinesssrvc.checkAuthentication(emailId,password), HttpStatus.OK);

		
	} catch (BusinessException e) {		
		System.out.println(e.getExceptionMessage());
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getExceptionMessage());
	}
	}
}


