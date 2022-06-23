package com.hm.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.user.dao.UserDao;
import com.hm.user.model.User;
import com.hm.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Override
	public User addUser(User userDetails) {
		// TODO Auto-generated method stub
		return userDao.saveUser(userDetails);
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUSers();
	}
	@Override
	public Optional<User> getUser(Long userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}
	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		 userDao.deleteUser(userId);
	}
	@Override
	public User updateUser(User userDetails, Long id) {
		// TODO Auto-generated method stub
		User user=userDao.getUserById(id).get();
		user.setName(userDetails.getName());
		User savedUser=userDao.saveUser(user);
		return savedUser;
	}
	

}
