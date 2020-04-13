package com.ecomplify.eventmanagement.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecomplify.eventmanagement.utils.S3uploadUtil;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(value="v1/training")
public class EventManagementServiceController{
	
	
	@Autowired
	S3uploadUtil s3uploadutil;
	
	@RequestMapping(value="/sayhello/{name}",method = RequestMethod.GET)
    public String sayHello( @PathVariable("name") String name) {
        return "Hello "+name;
    }
	
	
	@RequestMapping(value="/testaws/{name}",method = RequestMethod.GET)
    public String testaws( @PathVariable("name") String name) {
		
		File f = new File("D:\\test\\1.txt");
		
		s3uploadutil.uploadFile(f.getName(),f);
        return "Hello "+name;
    }
	
	
	
}