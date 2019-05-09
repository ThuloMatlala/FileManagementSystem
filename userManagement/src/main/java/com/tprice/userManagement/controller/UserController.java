package com.tprice.userManagement.controller;

import com.tprice.userManagement.model.User;
import com.tprice.userManagement.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User AddUser(@RequestBody User user){
                return userService.AddUser(user);
    }

    @GetMapping(value = "/users")
    public List<User> GetUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/id/{id}")
    public User findById(@PathVariable long id){
        return userService.GetUserById(id);
    }

    @GetMapping(value = "/users/lastName/{lastName}")
    public List<User> findByLastName(@PathVariable String lastName){
        return userService.GetUsersBySurname(lastName);
    }

    @PutMapping(value = "/users/id/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User newUserDetails){
        return userService.EditUser(id, newUserDetails);
    }

    @DeleteMapping(value ="/users/id/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.DeleteUser(id);
    }
}
