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

    public List<User> CreateMultipleUsers() {

        List<User> userList = new ArrayList<>();

        for(int i=1; i < 5; i++){
            User user = new User("Test First Name", "Test Last Name", "Test@email", "test Password");
            user.setId(i);
            user.setFirstName(String.format("%d%s",user.getId(), user.getFirstName()));
            System.out.println(user);
            userList.add(user);
        }

        return userList;
    }
}
