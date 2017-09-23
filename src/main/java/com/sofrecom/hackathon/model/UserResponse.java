package com.sofrecom.hackathon.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends OperationResponse {
	private User data = new User();

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}

}
