package hu.greenfox.ramin.controllers;


import hu.greenfox.ramin.models.MessageCenter;
import hu.greenfox.ramin.models.Respond;
import hu.greenfox.ramin.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainRestController {


  @Autowired
  MessageRepo messageRepo;

  @Autowired
  Respond respond;

  String url = "https://peertopeerchatapp.herokuapp.com/api/message/receive";

  RestTemplate restTemplate = new RestTemplate();

  @PutMapping("/api/message/receive")
  public Respond receive(@RequestBody MessageCenter messageCenter){
      messageRepo.save(messageCenter.message);
   //   respond.setStatus("Ok");
    restTemplate.postForObject(url, messageCenter, MessageCenter.class);
    return respond;
  }



}
