package com.sofrecom.hackathon.api;

import io.swagger.annotations.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sofrecom.hackathon.model.VersionModel;

import static org.springframework.http.MediaType.*;

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
