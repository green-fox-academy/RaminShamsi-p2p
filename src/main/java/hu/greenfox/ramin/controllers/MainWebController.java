package hu.greenfox.ramin.controllers;


import hu.greenfox.ramin.models.Message;
import hu.greenfox.ramin.models.InfoService;
import hu.greenfox.ramin.models.User;
import hu.greenfox.ramin.repository.MessageRepo;
import hu.greenfox.ramin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class MainWebController {

//  @GetMapping("/index")
//  public String home(Model model) {
//    if (userRepo.count() == 0) {
//      InfoService.infoRequest("/index", "get", user);
//      model.addAttribute("user", new User(""));
//      return "registerform";
//    } else {
//      return "index";
//    }
//  }

  // @PostMapping(value={"/","/"})

  @Autowired
  User user;
//  @Autowired
//  Message message;

  @Autowired
  UserRepo userRepo;
  @Autowired
  MessageRepo messageRepo;

  @GetMapping("/")
  public String register(Model model) {
    if (userRepo.count() == 0) {
      InfoService.infoRequest("/index", "get", user);
      model.addAttribute("user", new User(""));
      return "registerform";
    } else {
      model.addAttribute("user", userRepo.findOne(1L));
      model.addAttribute("allMessages", messageRepo.findAll());
      //     model.addAttribute("user", new User());
      return "index";
    }
  }
/*
  @PostMapping("/update")
  public String update(@RequestParam(name = "update") String newName) {
    User newUser = userRepo.findOne(1L);
    newUser.setUsername(newName);
    userRepo.save(newUser);
    return "redirect:/";
  }
  */

  @PostMapping("/update")
  public String update(User updatedUser) {
    User newUser = userRepo.findOne(1L);
    if (updatedUser.getUsername().isEmpty()) {
      newUser.setUsername(null);
    } else {
      newUser.setUsername(updatedUser.getUsername());
    }
    userRepo.save(newUser);
    return "redirect:/";
  }


  @PostMapping("/enter")
  public String submitRegister(User guestUser, Model model) {
    if (guestUser.getUsername().isEmpty()) {
      InfoService.infoRequest("/enter", "post", user);
      model.addAttribute("user", new User());
      return "registerform";
    } else if (userRepo.findByUsername(guestUser.getUsername()).size() != 0) {
      System.out.println("USER EXISTTTTTTTTTTTTTTTTTTTTTTTTT");
      return "database";
    } else {
      userRepo.save(guestUser);
      InfoService.infoRequest("/enter", "post", guestUser);
      System.out.println("There are " + userRepo.findByUsername(guestUser.getUsername()).size() + " user in database.");
      System.out.println("The username is: " + guestUser.getUsername());
      return "redirect:/";
    }
  }

  @PostMapping("/send")
  public String send(String text) {
    Message message = new Message();
    message.setText(text);
    message.setUsername(userRepo.findOne(1L).getUsername());
    messageRepo.save(message);
    return "redirect:/";
  }

  @GetMapping("/enter")
  public String submitRegister() {
    return "redirect:/";
  }
}
