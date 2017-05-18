package hu.greenfox.ramin.models;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

  @Id
  Double id;
  String username;
  String text;

  public Message() {
    this.id = Math.random()*10000000;
  }

  public Message(Double id) {
    this.id = Math.random()*10000000;
  }
}
