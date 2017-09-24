package com.sofrecom.hackathon.service;
import java.util.List;

import com.sofrecom.hackathon.model.*;
import com.sofrecom.hackathon.repository.UserRepo;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

	public String getLoggedInUserId(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth==null){
            return "nosession";
        }
		return auth.getName();
	}


	public User getLoggedInUser() {
		String loggedInUserId = this.getLoggedInUserId();
		System.out.format("\n1. Inside >> getLoggedInUser: %s", loggedInUserId);
		User user = this.getUserInfoByUserId(loggedInUserId);
		System.out.format("\n2. After Find User: %s", loggedInUserId);
		return user;
	}

	public User getUserInfoByUserId(String username){
			User user = this.userRepo.findOneByUsername(username).orElseGet( () -> new User());
			return user;
	}

	public boolean insertOrSaveUser(User user) {
		this.userRepo.save(user);
		return true;
	}

	public boolean addNewUser(User user) {
		User newUser = this.getUserInfoByUserId(user.getUsername());
		if (newUser.getUserId().equals("new")){
			// This means the username is not found therfore its is returning a default value of "new"
			return this.insertOrSaveUser(user);
		}
		else{
			return false;
		}
	}

	public List<User> findAll(){
		return userRepo.findAll();
	}
	
}
