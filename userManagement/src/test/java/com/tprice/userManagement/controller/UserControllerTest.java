package com.tprice.userManagement.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tprice.userManagement.TestHelper;
import com.tprice.userManagement.model.User;
import com.tprice.userManagement.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
//THE FOLLOWING TESTS ARE FOR TESTING WHETHER THE CONTROLLER RETURNS THE REQUIRED OBJECTS IDEALLY.
// I AM TESTING OBJECT MAPPING FROM MODEL TO VIEW.
//  THESE ARE NOT FOR TESTING BUSINESS LOGIC
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    private TestHelper testHelper = new TestHelper();

    @Before
    public void setUp(){
        Mockito.reset(userService);
    }

    @Test
    public void addUserShouldReturnCreatedUser() throws Exception {
        User user = testHelper.CreateSingleUser();

        when(userService.SaveUser(user)).thenReturn(user);

        mockMvc.perform(post("/api/users/create")
                .content(mapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(user.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(user.getLastName()))
                .andExpect(jsonPath("$.email").value(user.getEmail()))
                .andExpect(jsonPath("$.password").value(user.getPassword()));
        verify(userService, times(1)).SaveUser(user);
        verifyNoMoreInteractions(userService);
    }


    @Test
    public void editUserShouldReturnUserWithUpdatedPassword() throws Exception {
        User user = testHelper.CreateSingleUser();
        String newPassword = "new Password";

        user.setPassword(newPassword);
        when(userService.EditUser(user.getId(), user)).thenReturn(user);

        mockMvc.perform(put("/api/users/{id}", user.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(user)))
                .andExpect(jsonPath("$.firstName", Matchers.is(user.getFirstName())))
                .andExpect(jsonPath("$.lastName", Matchers.is(user.getLastName())))
                .andExpect(jsonPath("$.email", Matchers.is(user.getEmail())))
                .andExpect(jsonPath("$.password", Matchers.is(newPassword)));
        verify(userService, times(1)).EditUser(user.getId(), user);
        verifyNoMoreInteractions(userService);
    }



    @Test
        public void getAllUsersShouldReturnAListOfUsers() throws Exception {
        List<User> userList = testHelper.CreateMultipleUsers();

        when(userService.findAllUsers()).thenReturn(userList);

        mockMvc.perform(get("/api/users")
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", Matchers.hasSize(4)))
                .andExpect(jsonPath("$[0].firstName").value(userList.get(0).getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(userList.get(0).getLastName()));
        verify(userService, times(1)).findAllUsers();
        verifyNoMoreInteractions(userService);
    }


    @Test
    public void findByIdShouldReturnASingleUser() throws Exception {
        User user = testHelper.CreateSingleUser();
        long userId = 1;
        when(userService.GetOneUserById(userId)).thenReturn(user);

        mockMvc.perform(get("/api/users/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(((int) user.getId()))))
                .andExpect(jsonPath("$.firstName", Matchers.is(user.getFirstName())))
                .andExpect(jsonPath("$.lastName", Matchers.is(user.getLastName())))
                .andExpect(jsonPath("$.email", Matchers.is(user.getEmail())))
                .andExpect(jsonPath("$.password", Matchers.is(user.getPassword())));
        verify(userService, times(1)).GetOneUserById(userId);
        verifyNoMoreInteractions(userService);
    }


    @Test
    public void findByEmailShouldReturnASingleUser() throws Exception{
        List<User> userList = testHelper.CreateMultipleUsers();
        String userEmail = "Test@email";
        Stream<User> userStream = userList.stream().filter(user -> user.getEmail().equals(userEmail));
        Optional<User> userOptional = userStream.findFirst();
        User user = userOptional.orElse(new User());
        when(userService.FindUserByEmail(userEmail)).thenReturn(user);

        User expectedUser = userList.stream().filter(d -> d.getEmail().equals(userEmail)).findFirst().orElse(null);
        mockMvc.perform(get("/api/users/email?email={email}", userEmail)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(userService, times(1)).FindUserByEmail(userEmail);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void findByLastNameShouldReturnAListOfUsers() throws Exception {
        List<User> userList = testHelper.CreateMultipleUsers();
        String userLastName = "1Test Last Name";
        userList = userList.stream().filter(d -> d.getLastName().equals(userLastName)).collect(Collectors.toList());
        when(userService.FindUsersByLastName(userLastName)).thenReturn(userList);

        User expectedUser = userList.stream().filter(d -> d.getLastName().equals(userLastName)).findFirst().orElse(null);
        mockMvc.perform(get("/api/users/lastName?lastName={lastName}", userLastName)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].email", Matchers.is(expectedUser.getEmail())))
                .andExpect(jsonPath("$[0].password", Matchers.is(expectedUser.getPassword())))
                .andExpect(jsonPath("$[0].firstName", Matchers.is(expectedUser.getFirstName())))
                .andExpect(jsonPath("$[0].lastName", Matchers.is(expectedUser.getLastName())));
        verify(userService, times(1)).FindUsersByLastName(userLastName);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void deleteUserShouldReturnAnOkStatus() throws Exception {
        List<User> user = testHelper.CreateMultipleUsers();
        long userId = 3;

        mockMvc.perform(delete("/api/users/{id}", userId))
                .andExpect(status().isOk());
        verify(userService, times(1)).DeleteUserById(userId);
        verifyNoMoreInteractions(userService);
    }

}

