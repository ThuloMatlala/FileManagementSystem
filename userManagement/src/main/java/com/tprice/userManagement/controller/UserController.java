package com.tprice.userManagement.controller;

import com.tprice.userManagement.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    public UserController(){};

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User AddUser(@RequestBody User user){
        return user;
    }

//    @GetMapping(value = "/users")
//    public List<User> GetUsers(){
//    }

}
