package com.sofrecom.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.hackathon.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findOneByUserId(String userId);

	Optional<User> findOneByUserIdAndPassword(String userId, String password);

}
