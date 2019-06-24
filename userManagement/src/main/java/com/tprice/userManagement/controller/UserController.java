package com.tprice.userManagement.controller;

import com.tprice.userManagement.model.User;
import com.tprice.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ContextLoadT(){
        return "Si on";
    }


    @PostMapping(value = "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User AddUser(@RequestBody User user)
    {
        return userService.SaveUser(user);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> GetUsers(){
        return userService.findAllUsers();
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findById(@PathVariable long id){
        User user = userService.GetOneUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "/users/lastName")
    public List<User> findByLastName(@RequestParam(required = false) String lastName){
        return userService.FindUsersByLastName(lastName);
    }

    @PutMapping(value = "/users/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User newUserDetails){
        return userService.EditUser(id, newUserDetails);
    }

    @DeleteMapping(value ="/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.DeleteUserById(id);
    }
}