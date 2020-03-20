package com.ecomplify.eventmanagement.services;

import org.springframework.stereotype.Service;
import com.ecomplify.eventmanagement.repositories.UserRepository;
import com.ecomplify.eventmanagement.repositories.UserIdentifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecomplify.eventmanagement.models.entities.User;

@Service
public class ApplicationBusinessService {
	
    @Autowired
    UserRepository userRepo;

    @Autowired
    UserIdentifierRepository userIdentifierRepo;   


    public User checkAuthentication(String username,String password) throws Exception{
              User usr = null;

	      usr = userRepo.findByEmailid(username);

              System.out.println("gggg");
	      
  
		return null;

    
    }


}
