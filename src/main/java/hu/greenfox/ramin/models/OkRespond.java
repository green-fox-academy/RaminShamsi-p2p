package hu.greenfox.ramin.models;

import org.springframework.stereotype.Component;

@Component
public class OkRespond extends Respond{

  String status = "Okk";

  public OkRespond() {
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
