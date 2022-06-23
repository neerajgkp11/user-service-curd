package com.hm.user.dao.impl;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.hm.user.dao.UserDao;
import com.hm.user.model.User;
import com.hm.user.repository.UserRepository;
import com.hm.user.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class UserDaoImplTest {
	
	@InjectMocks
	UserDaoImpl userDaoImpl;
	
	@Mock
	UserRepository userRepository;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void testSaveUser() {
		User user=new User();
		user.setId(1L);
		user.setName("test");
		when(userRepository.save(any())).thenReturn(user);
		User savedUser=userDaoImpl.saveUser(user);
		Mockito.verify(userRepository, Mockito.times(1)).save(any());
		assertEquals("test", savedUser.getName());

	}
	

	@Test
	public void testGetAllUsers() {
		List<User> list = new ArrayList<User>();
		for (long i = 1; i <= 5; i++) {
			User user = new User();
			user.setId(i);
			user.setName("test" + i);
			list.add(user);
		}

		when(userRepository.findAll()).thenReturn(list);
		List<User> userList = userDaoImpl.getAllUSers();
		Mockito.verify(userRepository, Mockito.times(1)).findAll();
		assertEquals("test5", userList.get(4).getName());
	}
	
	
	@Test
	public void testGetUserById() {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(1L);
		user.setName("test");
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
		Optional<User> userFetched=userDaoImpl.getUserById(1L);
		Mockito.verify(userRepository, Mockito.times(1)).findById(anyLong());
		assertEquals("test", userFetched.get().getName());
	}
	
	

}
