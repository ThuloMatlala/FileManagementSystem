package com.tprice.userManagement.service;

import com.tprice.userManagement.TestHelper;
import com.tprice.userManagement.model.User;
import com.tprice.userManagement.repo.UserRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceLayerUnitTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void getUsers(){
        when(userRepo.findAll()).thenReturn(Stream.of(
                new User("TestFirstName0", "TestLastName0"),
                new User("TestFirstName1", "TestLastName1")).collect(Collectors.toList()));
        Assert.assertEquals(2 , userService.getAllUsers().size());
    }
}
