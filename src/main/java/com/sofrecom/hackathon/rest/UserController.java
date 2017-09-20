package com.sofrecom.hackathon.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.hackathon.business.UserService;
import com.sofrecom.hackathon.model.persistent.User;
import com.wordnik.swagger.annotations.Api;

@Api(value = "user", description = "Users Controller API")
@RestController
public class UserController extends BaseController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		if (user !=null) {
			userService.saveOrUpdate(user);
			return new ResponseEntity<User>(HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
