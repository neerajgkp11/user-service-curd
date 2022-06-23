package com.hm.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.hm.user.model.User;

public interface UserService {

	User addUser(User userDetails);

	List<User> getAllUsers();

	Optional<User> getUser(Long userId);

	void deleteUser(Long userId);
	
	User updateUser(User userDetails, Long id);

	
}

