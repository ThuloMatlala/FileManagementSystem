package com.tprice.userManagement.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "position")
    private String position;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "tradingName")
    private String tradingName;
    @Column(name = "cdibGrade")
    private String cdibGrade;
}
