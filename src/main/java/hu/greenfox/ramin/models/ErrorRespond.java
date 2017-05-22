package hu.greenfox.ramin.models;


import org.springframework.stereotype.Component;

@Component
public class ErrorRespond extends Respond {

  String status;
  String message;

  public ErrorRespond() {

  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
