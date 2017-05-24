package hu.greenfox.ramin.models;


import org.springframework.stereotype.Component;

@Component
public class ErrorRespond extends Respond {

  String status;
  String message;

  public ErrorRespond() {
    this.status = "error";
    this.message = "Missing field(s): message.timestamp, client.id";
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
