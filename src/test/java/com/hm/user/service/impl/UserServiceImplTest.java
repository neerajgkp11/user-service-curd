package com.hm.user.service.impl;

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

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserDao userDao;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void testAddUser() {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(1L);
		user.setName("test");
		when(userDao.saveUser(any())).thenReturn(user);
		User savedUser=userServiceImpl.addUser(user);
		Mockito.verify(userDao, Mockito.times(1)).saveUser(any());
		assertEquals("test", savedUser.getName());
	}
	
	@Test
	public void testGetAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		for (long i = 1; i <= 10; i++) {
			User user = new User();
			user.setId(i);
			user.setName("test" + i);
			list.add(user);
		}
		when(userDao.getAllUSers()).thenReturn(list);
		List<User> userList = userServiceImpl.getAllUsers();
		assertEquals(10, userList.size());
		verify(userDao, times(1)).getAllUSers();
		assertEquals("test1", userList.get(0).getName());

	}
	
	@Test
	public void testGetUser() {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(1L);
		user.setName("test");
		Mockito.when(userDao.getUserById(Mockito.anyLong())).thenReturn(Optional.of(user));	
		Optional<User> userData=userServiceImpl.getUser(1L);
		Mockito.verify(userDao, Mockito.times(1)).getUserById(1L);
		assertEquals("test", userData.get().getName());
	}
	

	@Test
	public void testDeleteUser() {
		// TODO Auto-generated method stub
		Mockito.when(userDao.deleteUser(anyLong())).thenReturn(true);
		userServiceImpl.deleteUser(1L);
		Mockito.verify(userDao, Mockito.times(1)).deleteUser(1L);
	}
	
	@Test
	public void testUpdateUser() {
		User user=new User();
		user.setId(1L);
		user.setName("test");
		Mockito.when(userDao.getUserById(anyLong())).thenReturn(Optional.of(user));
		Mockito.when(userDao.saveUser(any())).thenReturn(user);
		User updatedUser=userServiceImpl.updateUser(user,1L);
		Mockito.verify(userDao, Mockito.times(1)).getUserById(anyLong());
		Mockito.verify(userDao, Mockito.times(1)).saveUser(any());
		assertEquals("test", updatedUser.getName());
	}
	

}
