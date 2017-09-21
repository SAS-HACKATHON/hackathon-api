package com.sofrecom.hackathon.model;


import io.swagger.annotations.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class SessionResponse extends OperationResponse {
	@ApiModelProperty(required = true, value = "")
	private SessionItem item;

	public SessionItem getItem() {
		return item;
	}

	public void setItem(SessionItem item) {
		this.item = item;
	}

}
