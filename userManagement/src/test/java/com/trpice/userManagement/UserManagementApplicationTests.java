package com.trpice.userManagement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementApplicationTests {

	@InjectMocks
	private User user;
	private MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(user).build();
	}
	@Test
	public void contextLoads() {

	}

	@Test
	public void shouldReturnUserObject(){
		User test = mock(User.class);


	}
}
