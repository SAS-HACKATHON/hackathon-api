package com.sofrecom.hackathon.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.sofrecom.hackathon.model.User;

public class TokenUser extends org.springframework.security.core.userdetails.User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	// For returning a normal user
	public TokenUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		// super(user.getUserName(), user.getPassword(), true, true, true, true,
		// AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getRole() {
		return user.getRole().toString();
	}
}
