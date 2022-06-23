package com.hm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
