package com.tprice.userManagement.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tprice.userManagement.TestHelper;
import com.tprice.userManagement.model.User;
import com.tprice.userManagement.repo.UserRepo;
import com.tprice.userManagement.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;


import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserIntegrationTests
{

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestEntityManager entityManager;

    private TestHelper testHelper = new TestHelper();

    @Autowired
    private UserRepo userRepo;

    private List<User> userList;

    @Before
    public void setUp()
    {
        userList = testHelper.CreateMultipleUsers();
        userList.forEach(user -> this.entityManager.persistAndFlush(user));
        Mockito.reset(userService);
    }


}
