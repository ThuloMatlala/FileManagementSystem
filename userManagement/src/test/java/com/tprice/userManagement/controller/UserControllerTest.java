package com.tprice.userManagement.controller;

import com.tprice.userManagement.model.UserApi;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserApi userApi;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void addUser() throws Exception {
        String testUser = "{\n" +
                "  \"firstName\": \"Test First Name\",\n" +
                "  \"lastName\": \"Test Last Name\"\n" +
                "}";
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON).
                        content(testUser)).andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Matchers.is("Thulo")))
                .andExpect(jsonPath("$.lastName", Matchers.is("Still Thulo")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }
}