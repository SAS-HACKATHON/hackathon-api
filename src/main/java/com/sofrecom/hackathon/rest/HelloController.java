package com.sofrecom.hackathon.rest;

	
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

@Api(value = "hello", description = "Hello Controller API")
@RestController
public class HelloController extends BaseController {

	@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String sayHello() {
		
		return "Hello World!";
	}



}
