package com.tprice.userManagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Client
{
  private @Id @GeneratedValue Long id;
  private String username;
  private String password;
    private String role;

  private Client (String username, String password, String role){
      this.username = username;
      this.password = password;
      this.role = role;
  }
}
