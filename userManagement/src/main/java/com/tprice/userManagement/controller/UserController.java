package com.tprice.userManagement.controller;

import com.tprice.userManagement.model.User;
import com.tprice.userManagement.model.UserService;
import com.tprice.userManagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){};

    @PostMapping(value = "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User AddUser(@RequestBody User user){
        return user;
    }

    @GetMapping(value = "/users")
    public List<User> GetUsers(){
        List<User> usersList = new ArrayList<>();
        return usersList;
    }

}
