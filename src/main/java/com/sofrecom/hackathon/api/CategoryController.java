package com.sofrecom.hackathon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.hackathon.model.Category;
import com.sofrecom.hackathon.model.User;
import com.sofrecom.hackathon.model.UserResponse;
import com.sofrecom.hackathon.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Category" })
public class CategoryController extends BaseController {
	
	@Autowired
	CategoryService categoryService;

	@ApiOperation(value = "Gets All Categories", response = UserResponse.class)
	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Category>> getAllCategories() {

		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);

	}
	
}
