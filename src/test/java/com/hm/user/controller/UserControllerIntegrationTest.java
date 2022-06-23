package com.hm.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hm.user.dao.UserDao;
import com.hm.user.repository.UserRepository;
import com.hm.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIntegrationTest {
	
	@Autowired
	private UserController userController;
	private MockMvc mockMvc;
	private HttpHeaders headers = new HttpHeaders();
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private UserDao userDao;
	
	
	@MockBean
	private UserRepository userRepository;
	
	@BeforeEach
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testGetAllUser() throws Exception {
		MvcResult result = this.mockMvc
				.perform(get("/api/users").headers(headers).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		this.mockMvc.perform(asyncDispatch(result)).andExpect(status().is2xxSuccessful());
				//.andExpect(jsonPath("$.social.twitter").value(1));
	}


}
