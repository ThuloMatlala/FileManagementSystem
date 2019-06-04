package com.tprice.userManagement;

import com.tprice.userManagement.model.User;
import org.json.JSONException;
import org.json.JSONObject;
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
        for(int i=0; i < 5; i++){
            User user = new User("Test First Name", "Test Last Name", "Test@email", "test Password");
            user.setFirstName(String.format("%d%s",i, user.getFirstName()));
        }

        return new ArrayList<>();
    }
}
