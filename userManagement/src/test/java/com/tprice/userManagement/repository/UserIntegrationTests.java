package com.tprice.userManagement.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tprice.userManagement.TestHelper;
import com.tprice.userManagement.UserManagementApplication;
import com.tprice.userManagement.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = UserManagementApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yml")
public class UserIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TestHelper testHelper;

    @Autowired
    private ObjectMapper mapper;

    private List<User> userList;
    @Before
    public void setup()
    {
        userList = testHelper.CreateMultipleUsers();
        userList.forEach(user -> {
            try {
                mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create")
                        .content(mapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())

                        .andReturn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void SmokeScreenTest() throws Exception
    {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void GetAllUsersShouldReturnAListOfUsers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", Matchers.hasSize(4)))
                .andExpect(jsonPath("$[0].firstName").value(userList.get(0).getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(userList.get(0).getLastName()))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void GetAllUsersByEmailShouldReturnASingleUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{id}", "nonexistent@email.com")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
