package com.hm.user.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hm.user.dao.UserDao;
import com.hm.user.model.User;
import com.hm.user.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User userDetails) {
		
		return userRepository.save(userDetails);
	}

	@Override
	public List<User> getAllUSers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public boolean deleteUser(Long userId) {
		// TODO Auto-generated method stub
		 userRepository.deleteById(userId);
		 return true;
	}

}
