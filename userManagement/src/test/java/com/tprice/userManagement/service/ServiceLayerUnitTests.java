//package com.tprice.userManagement.service;
//
//import com.tprice.userManagement.model.User;
//import com.tprice.userManagement.repo.UserRepo;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class ServiceLayerUnitTests {
//
//    @Autowired
//    private UserService userService;
//
//    @MockBean
//    private UserRepo userRepo;
//
//    @Test
//    public void addUser() {
//        User newUser = new User(, , "TestFirstName0", "TestLastName0");
//        when(userRepo.save(newUser)).thenReturn(newUser);
//        Assert.assertEquals(newUser, userService.SaveUser(newUser));
//    }
//
//    @Test
//    public void getUsers() {
//        when(userRepo.findAll()).thenReturn(Stream.of(
//                new User(, , "Test@email.com0", "Test_Password0"),
//                new User(, , "Test@email.com1", "Test_Password1")).collect(Collectors.toList()));
//        Assert.assertEquals(2, userService.findAllUsers().size());
//    }
//
//    @Test
//    public void getUserById() {
//        User mockUser = new User(, , "Test@email.com0", "Test_Password0");
//        Long id = 1L;
//        when(userRepo.getOne(id)).thenReturn(mockUser);
//        Assert.assertEquals(mockUser, userService.GetOneUserById(id));
//    }
//
//    @Test
//    public void getUserByLastName() {
//        String lastName = "TestLastName";
//        User userToFound = new User(, , "Test@email.com0", "Test_Password0");
//        User userToFound2 = new User(, , "Test@email.com1", "Test_Password1");
//        when(userRepo.findByLastName(lastName)).thenReturn(Stream.of(userToFound, userToFound2).collect(Collectors.toList()));
//        Assert.assertEquals(2, userService.FindUsersByLastName(lastName).size());
//    }
//
//    @Test
//    public void deleteUser() {
//        User userToDeleted = new User(, , "Test@email.com0", "Test_Password0");
////        ReflectionTestUtils.setField("userToFound", "id", 1);
//        userService.DeleteUserById(userToDeleted.getId());
//        verify(userRepo, times(1)).deleteById(userToDeleted.getId());
//    }
//}
