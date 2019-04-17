package com.tprice.userManagement.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.tprice.userManagement.TestHelper;
import com.tprice.userManagement.model.User;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.FileWriter;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    private User user;

    @InjectMocks
    private UserController userController;

    private TestHelper testHelper;

    @Before
    public void setUp(){
        user = mock(User.class);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void addUser() throws Exception {
        testHelper = new TestHelper();
        JSONObject userDetails = testHelper.AddSingleUser();

        mockMvc.perform(post("/api/users/create")
                .contentType(MediaType.APPLICATION_JSON).
                        content(userDetails.toString())).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.firstName", Matchers.is("Test First Name")))
                .andExpect(jsonPath("$.lastName", Matchers.is("Test Last Name")))
                .andExpect(jsonPath("$.phone", Matchers.is("+00(111)-222-3333")))
                .andExpect(jsonPath("$.position", Matchers.is("Test Position")))
                .andExpect(jsonPath("$.companyName", Matchers.is("Test Company")))
                .andExpect(jsonPath("$.tradingName", Matchers.is("Test Trading Name")))
                .andExpect(jsonPath("$.cdibGrade", Matchers.is("Test CDIB GRADE")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(9)));
    }

    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(get("/api/users")).andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/api/users/id/{id}",1L).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void findByLastName() throws Exception {
        mockMvc.perform(get("/api/users/lastName/{lastName}", "THULO").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void editUser() throws Exception {
        testHelper = new TestHelper();
        JSONObject userDetails = testHelper.AddSingleUser();

        mockMvc.perform(put("/api/users/id/{id}", 1L).
                contentType(MediaType.APPLICATION_JSON).content(userDetails.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/id/{id}", 1L) .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}