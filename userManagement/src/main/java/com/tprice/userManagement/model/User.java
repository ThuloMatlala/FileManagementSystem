package com.tprice.userManagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class User {

    public User(){};

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String position;
    private String compayName;
    private String tradingName;
    private String cdibGrade;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompayName() {
        return compayName;
    }

    public void setCompayName(String compayName) {
        this.compayName = compayName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getCdibGrade() {
        return cdibGrade;
    }

    public void setCdibGrade(String cdibGrade) {
        this.cdibGrade = cdibGrade;
    }
}
