package com.tprice.userManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role;
    private String password;

    protected User(String firstName, String lastName, String email, String phoneNumber, String role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;
    }
}
