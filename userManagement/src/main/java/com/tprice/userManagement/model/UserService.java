package com.tprice.userManagement.model;

import com.tprice.userManagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User AddUser(User user)
    {
        User newUser = userRepo.save(user);
        return newUser;
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        userRepo.findAll().forEach(usersList::add);
        return usersList;
    }
}
