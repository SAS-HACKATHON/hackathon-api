package com.sofrecom.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.sofrecom.hackathon.model.persistent.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	 User  findByUsername(String username);
}
