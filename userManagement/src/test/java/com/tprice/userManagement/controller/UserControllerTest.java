package com.tprice.userManagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tprice.userManagement.model.User;
import com.tprice.userManagement.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void addUserShouldReturnCreatedUser() throws Exception {
        User user = new User("TestFirstName", "TestLastName", "Test@Email", "TestPassword");

        when(userService.SaveUser(user)).thenReturn(user);

        mockMvc.perform(post("/api/users/create")
                .content(mapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


}

//    @Test
//    public void getAllUsers() throws Exception {
//        mockMvc.perform(get("/api/users")).andExpect(status().isOk());
//    }
//
//    @Test
//    public void findById() throws Exception {
//        mockMvc.perform(get("/api/users/{id}",1L).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//    }
//
//    @Test
//    public void findByLastName() throws Exception {
//        mockMvc.perform(get("/api/users/lastName?lastName={lastName}", "THULO").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//    }
//
//    @Test
//    public void editUser() throws Exception {
//        testHelper = new TestHelper();
//        JSONObject userDetails = testHelper.AddSingleUserJSONObject();
//
//        mockMvc.perform(put("/api/users/{id}", 1L).
//                contentType(MediaType.APPLICATION_JSON).content(userDetails.toString()))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void deleteUser() throws Exception {
//        mockMvc.perform(delete("/api/users/{id}", 1L) .contentType(MediaType.APPLICATION_JSON)
//        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
