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
    	  UserIdentifier usrIdentifier = null;
    	  
	      usr = userRepo.findByEmail(username);
	      
	      if(usr!=null) {
	    	  usrIdentifier = userIdentifierRepo.findByUserId(usr.getAppuserid());
	    	  
	    	  if(!usrIdentifier.getUserIdentifierText().equals(password)) {
	    		  throw new BusinessException("Passowrd is Wrong");
	    	  }
	    	  
	      }else {
	    	  throw new BusinessException("User Id is not available");
	      }   

      return usr;

    
    }


}
