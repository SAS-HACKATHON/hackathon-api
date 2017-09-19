package com.sofrecom.hackathon.business;

import com.sofrecom.hackathon.model.persistent.User;

public interface UserService extends CRUDService<User> {

	User findByUsername(String email);

}