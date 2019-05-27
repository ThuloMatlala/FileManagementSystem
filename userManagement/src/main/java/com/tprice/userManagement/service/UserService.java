package com.tprice.userManagement.service;

import com.tprice.userManagement.model.User;
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
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userRepo.findAll());
    }

    public User GetUserById(long id){
        return userRepo.getOne(id);
    }

    public List<User> GetUsersBySurname(String lastName) {
        return userRepo.findByLastName(lastName);
    }

    public User EditUser(Long id, User newUserDetails) {
        User userToUpdate = userRepo.getOne(id);
        userToUpdate.setFirstName(newUserDetails.getFirstName());
        userToUpdate.setLastName(newUserDetails.getLastName());
        userToUpdate.setEmail(newUserDetails.getEmail());
        userToUpdate.setPhone(newUserDetails.getPhone());
        userToUpdate.setCompanyName(newUserDetails.getCompanyName());
        userToUpdate.setTradingName(newUserDetails.getTradingName());
        userToUpdate.setPosition(newUserDetails.getPosition());
        userToUpdate.setCdibGrade(newUserDetails.getCdibGrade());
        return userRepo.save(userToUpdate);
    }

    public void DeleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
