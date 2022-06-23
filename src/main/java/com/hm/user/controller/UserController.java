package com.hm.user.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.user.model.User;
import com.hm.user.service.UserService;

@RestController
@RequestMapping("/api") 
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public  ResponseEntity<List<User>> getAllUser() {
		List<User>  users= userService.getAllUsers();
		return	new ResponseEntity<>(users, HttpStatus.OK);
		

	}
	
	@GetMapping("/user/{userId}")
	public  ResponseEntity<User> getUser(@PathVariable("userId") Long userId) {
		Optional<User> user=userService.getUser(userId);
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
		

	}
	
	@PostMapping("/user")
	public  ResponseEntity<User> addUser(@RequestBody User userDetails) {
		
		User user=userService.addUser(userDetails);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
		

	}
	
	@PutMapping("/user/{id}")  
	private ResponseEntity<User> updateUser(@RequestBody User userDetails,@PathVariable("id") Long id)   
	{  
		User user=userService.updateUser(userDetails,id);  
		return new ResponseEntity<>(user, HttpStatus.OK);
	}  
	

	@DeleteMapping("/user/{userid}")
	public  void deleteUser(@PathVariable("userid") Long userId) {
		
		userService.deleteUser(userId);
		
		

	}

}
