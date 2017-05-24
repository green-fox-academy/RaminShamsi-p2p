package hu.greenfox.ramin.controllers;


import hu.greenfox.ramin.models.ErrorRespond;
import hu.greenfox.ramin.models.MessageCenter;
import hu.greenfox.ramin.models.OkRespond;
import hu.greenfox.ramin.models.Respond;
import hu.greenfox.ramin.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainRestController {


  @Autowired
  MessageRepo messageRepo;

  @Autowired
  OkRespond respond;
 // String url = "https://greenfox-chat-app.herokuapp.com/api/message/receive";   //Ramin
  // String url = "https://peertopeerchatapp.herokuapp.com/api/message/receive";  //George
  // String url = "https://reka-greenfox-p2pchatapp.herokuapp.com/api/message/receive";  ///Réka

  String url = System.getenv("CHAT_APP_PEER_ADDRESSS");
  String clientId = System.getenv("CHAT_APP_UNIQUE_ID");
  RestTemplate restTemplate = new RestTemplate();

  @CrossOrigin("*")
  @PostMapping("/api/message/receive")
  public ResponseEntity receive(@RequestBody MessageCenter messageCenter) {
    if (messageCenter.message.getUsername() == null ||
            messageCenter.message.getText() == null ||
            messageCenter.client.getId() == null) {
      return new ResponseEntity<Respond>(new ErrorRespond(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    } else if (!messageCenter.client.getId().equals(clientId)) {
      messageRepo.save(messageCenter.message);
      //    respond.setStatus("ok");
      Respond r = restTemplate.postForObject(url, messageCenter, Respond.class);
      return new ResponseEntity<Respond>(r, new HttpHeaders(), HttpStatus.OK);
    } else {
      return new ResponseEntity<Respond>(new OkRespond(), new HttpHeaders(), HttpStatus.OK);
    }
  }
}
