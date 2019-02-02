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

  private Client (String username, String password){
      this.username = username;
      this.password = password;
  }
}
