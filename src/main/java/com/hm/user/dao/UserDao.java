package com.hm.user.dao;

import java.util.List;
import java.util.Optional;

import com.hm.user.model.User;

public interface UserDao {

	User saveUser(User userDetails);

	List<User> getAllUSers();

	Optional<User> getUserById(Long userId);

	boolean deleteUser(Long userId);
	

}


