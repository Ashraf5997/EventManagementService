package com.ecomplify.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(value="v1/training")
public class EventManagementServiceController{
	
	@RequestMapping(value="/sayhello/{name}",method = RequestMethod.GET)
    public String sayHello( @PathVariable("name") String name) {
        return "Hello "+name;
    }
	
}