package com.sofrecom.hackathon.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.hackathon.model.VersionModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/", produces = { "application/json" })
@Api(tags = {"Common"})
public class Version {
  @ApiOperation(value = "Gets the version of the REST API", notes = "", response = VersionModel.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Returns the version info for the REST API.", response = VersionModel.class) })
  @RequestMapping( method = RequestMethod.GET)
  public VersionModel getVersion() {
      VersionModel r = new VersionModel();
      
      r.setMajor(1);
      r.setMinor(0);
      r.setPatch(0);
      r.setVersion(getVersion(r));
      return r;
  }
  
  public static final String getVersion(VersionModel model) {
	return model.getMajor()+"."+model.getMinor()+"."+model.getPatch();
	  
  }
}
