package hu.greenfox.ramin.controllers;


import hu.greenfox.ramin.models.MessageCenter;
import hu.greenfox.ramin.models.OkRespond;
import hu.greenfox.ramin.models.Respond;
import hu.greenfox.ramin.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainRestController {


  @Autowired
  MessageRepo messageRepo;

  @Autowired
  OkRespond respond;

  String url = "https://greenfox-chat-app.herokuapp.com/api/message/receive";

  RestTemplate restTemplate = new RestTemplate();

  @CrossOrigin("*")
  @PostMapping("/api/message/receive")
  public OkRespond receive(@RequestBody MessageCenter messageCenter) {
    messageRepo.save(messageCenter.message);
    respond.setStatus("ok");
    OkRespond r = restTemplate.postForObject(url, messageCenter, OkRespond.class);
    return r;
  }


}
