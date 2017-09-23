package com.sofrecom.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.hackathon.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findOneByUsername(String username);

	Optional<User> findOneByUsernameAndPassword(String username, String password);

}
