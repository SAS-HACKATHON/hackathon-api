package com.sofrecom.hackathon.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;
import com.sofrecom.hackathon.model.OperationResponse;
import com.sofrecom.hackathon.model.OperationResponse.ResponseStatusEnum;
import com.sofrecom.hackathon.model.User;
import com.sofrecom.hackathon.model.UserResponse;
import com.sofrecom.hackathon.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Authentication" })
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Gets current user information", response = UserResponse.class)
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = { "application/json" })
	public UserResponse getUserInformation(@RequestParam(value = "name", required = false) String userIdParam,
			HttpServletRequest req) {

		String loggedInUserId = userService.getLoggedInUserId();

		User user;
		boolean provideUserDetails = false;

		if (Strings.isNullOrEmpty(userIdParam)) {
			provideUserDetails = true;
			user = userService.getLoggedInUser();
		} else if (loggedInUserId.equals(userIdParam)) {
			provideUserDetails = true;
			user = userService.getLoggedInUser();
		} else {
			// Check if the current user is superuser then provide the details of requested
			// user
			provideUserDetails = true;
			user = userService.getUserInfoByUserId(userIdParam);
		}

		UserResponse resp = new UserResponse();
		if (provideUserDetails) {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
		} else {
			resp.setOperationStatus(ResponseStatusEnum.NO_ACCESS);
			resp.setOperationMessage("No Access");
		}
		resp.setData(user);
		return resp;
	}

	@ApiOperation(value = "Gets All Users", response = UserResponse.class)
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<User>> getAllUsers() {

		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

	}

	@ApiOperation(value = "Add new user", response = OperationResponse.class)
	@RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = { "application/json" })
	public OperationResponse addNewUser(@RequestBody User user, HttpServletRequest req) {
		boolean userAddSuccess = userService.addNewUser(user);
		OperationResponse resp = new OperationResponse();
		if (userAddSuccess == true) {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("User Added");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add user");
		}
		return resp;
	}

}
