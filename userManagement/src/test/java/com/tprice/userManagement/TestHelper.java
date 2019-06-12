package com.tprice.userManagement;

import com.tprice.userManagement.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestHelper {

    public User CreateSingleUser() {
        User user = new User("Test First Name", "Test Last Name", "Test@email", "test Password");
        return user;
    }

    public List<User> CreateMultipleUsers()
    {

        List<User> userList = new ArrayList<>();

        for(int i=1; i < 5; i++)
        {
            User user = new User("Test First Name", "Test Last Name", "Test@email", "test Password");
            user.setId(i);
            user.setFirstName(String.format("%d%s", user.getId(), user.getFirstName()));
            user.setLastName(String.format("%d%s", user.getId(), user.getLastName()));
            user.setEmail(String.format("%d%s", user.getId(), user.getEmail()));
            user.setPassword(String.format("%d%s", user.getId(), user.getPassword()));
            userList.add(user);
        }
        System.out.println(userList);
        return userList;
    }
}
