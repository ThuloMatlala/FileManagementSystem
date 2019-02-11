package com.tprice.userManagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@Entity
class User
{
  private @Id @GeneratedValue Long id;
  private String username;
  private String password;
  private String role;
  private String subscriptionStatus;

  private User(String username, String password, String role){
      this.username = username;
      this.password = password;
      this.role = role;
  }
}
