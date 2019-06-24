package com.tprice.userManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
@TableGenerator(name="tab", initialValue=0, allocationSize=50)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    public User(){};

    public User(String firstName, String lastName, String email, String password){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "position")
    private String position;

    @Column(name = "companyName")
    private String companyName;
}
