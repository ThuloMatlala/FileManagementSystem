package com.tprice.userManagement.controller;

import com.tprice.userManagement.model.User;
import com.tprice.userManagement.model.UserApi;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private UserApi userApi;

    public UserController(UserApi userApi){
        this.userApi = userApi;
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User AddUser(@RequestBody User user){
//        User newUser = userApi.AddUser(user);
        return user;
    }

}
