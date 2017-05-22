package hu.greenfox.ramin.models;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;

@Component
@Entity
public class Message {

  @Id
  Long id;
  String username;
  String text;
  Timestamp timestamp;

  public Message() {
    this.id = Math.round(Math.random() * 10000000);
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message(Long id) {
    this.id = Math.round(Math.random() * 10000000);
    this.timestamp = new Timestamp(System.currentTimeMillis());
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "Message{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", text='" + text + '\'' +
            ", timestamp=" + timestamp +
            '}';
  }
}
