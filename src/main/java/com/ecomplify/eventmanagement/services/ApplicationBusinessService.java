package com.ecomplify.eventmanagement.services;

import org.springframework.stereotype.Service;
import com.ecomplify.eventmanagement.repositories.UserRepository;
import com.ecomplify.eventmanagement.repositories.UserIdentifierRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;


import com.ecomplify.eventmanagement.exceptions.BusinessException;
import com.ecomplify.eventmanagement.models.entities.User;
import com.ecomplify.eventmanagement.models.entities.UserIdentifier;

import com.ecomplify.eventmanagement.models.entities.User;
import java.time.LocalDateTime;


@Service
public class ApplicationBusinessService {
	
    @Autowired
    UserRepository userRepo;

    @Autowired
    UserIdentifierRepository userIdentifierRepo;   



    public User checkAuthentication(String username,String password) throws BusinessException{
          
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
    
    
	public String deleteUser(long appuserid) throws BusinessException  {

		UserIdentifier ui = null;
		ui = userIdentifierRepo.findByUserId(appuserid);
		
		if(ui!=null) {
			
			userIdentifierRepo.deleteById(ui.getUserIdentifierId());
			
			userRepo.deleteById(appuserid);
			
		}else {
			throw new BusinessException("User Identifier is not avaialible"); 
		}
		
		return "Success";
		

	}
    
    public String createUser(User usr) throws BusinessException {
    	
    	
    	String str = "Success";
    	
    	User tmpUsr = null;    	
    	tmpUsr = userRepo.save(usr);
    	
    	if(tmpUsr!=null) {
    		
    		UserIdentifier usrId = new UserIdentifier();
    		
    		usrId.setUserId(tmpUsr.getAppuserid());
    		usrId.setUserIdentifierText(usr.getAccesstext());
    		usrId.setDeleted("N");
    		usrId.setIdentifierValidatedtoDate(LocalDateTime.now());
    		
    		userIdentifierRepo.save(usrId);
    		
    	}else {
    		throw new BusinessException("Unable to dave the user data");
    	}

    		
    	return str;
    	
    }
    
    
    public String updateUser(User usr,long appuserid) throws BusinessException{
    
    	
    	String str = "Success";
    	
    	usr.setAppuserid(appuserid);
    	
    	userRepo.save(usr);
    	
    	return str;
    }


}
