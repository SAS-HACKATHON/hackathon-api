package com.sofrecom.hackathon.api;

import io.swagger.annotations.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.sofrecom.hackathon.model.OperationResponse.*;

import javax.servlet.http.*;

import com.sofrecom.hackathon.model.*;
import com.sofrecom.hackathon.repository.*;

/*
This is a dummy rest controller, for the purpose of documentation (/session) path is map to a filter
 - This will only be invoked if security is disabled
 - If Security is enabled then SessionFilter.java is invoked
 - Enabling and Disabling Security is done at config/applicaton.properties 'security.ignored=/**'
*/

@RestController
@Api(tags = { "Authentication" })
public class SessionController extends BaseController {

	@Autowired
	private UserRepo userRepo;

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Will return a security token, which must be passed in every request", response = SessionResponse.class) })
	@RequestMapping(value = "session", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SessionResponse newSession(@RequestBody Login login, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.format("\n /Session Called username=%s\n", login.getUsername());
		User user = userRepo.findOneByUsernameAndPassword(login.getUsername(), login.getPassword()).orElse(null);
		SessionResponse resp = new SessionResponse();
		SessionItem sessionItem = new SessionItem();
		if (user != null) {
			System.out.format("\n /User Details=%s\n", user.getFirstName());
			sessionItem.setToken("xxx.xxx.xxx");
			sessionItem.setUserId(user.getUserId());
			sessionItem.setFirstName(user.getFirstName());
			sessionItem.setLastName(user.getLastName());
			sessionItem.setEmail(user.getEmail());
			// sessionItem.setRole(user.getRole());

			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Dummy Login Success");
			resp.setItem(sessionItem);
		} else {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Login Failed");
		}
		return resp;
	}

}
