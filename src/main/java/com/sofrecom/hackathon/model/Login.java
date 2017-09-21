package com.sofrecom.hackathon.model;

import io.swagger.annotations.*;
import lombok.*;

@Data
public class Login {

	@ApiModelProperty(example = "demo", required = true)
	private String username = "";

	@ApiModelProperty(example = "demo", required = true)
	private String password = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
