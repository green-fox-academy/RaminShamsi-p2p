package hu.greenfox.ramin.models;


import org.hibernate.annotations.Table;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Component
@Entity(name = "UserTable")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String username;

  public User() {

  }

  public User(Long id) {
    this.id = id;
  }

  public User(String username) {
    this.username = username;
  }

  public User(Long id, String username) {
    this.id = id;
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public boolean noNameError(){
    return true;
  }
}
