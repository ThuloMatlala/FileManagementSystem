package com.tprice.userManagement.model;

public class UserApi {

    public User AddUser(User user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return newUser;
    }
}
