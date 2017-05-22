package hu.greenfox.ramin.models;

import org.springframework.beans.factory.annotation.Autowired;



public class Client {

//  @Autowired
//  User user;
//
// public String id = user.getUsername();
//
  public String id = "Ramin";

 public Client(){

 }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
