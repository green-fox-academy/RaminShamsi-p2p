package hu.greenfox.ramin.controllers;


import hu.greenfox.ramin.models.Service;
import hu.greenfox.ramin.models.User;
import hu.greenfox.ramin.repository.MessageRepo;
import hu.greenfox.ramin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class WebController {

//  @GetMapping("/index")
//  public String home(Model model) {
//    if (userRepo.count() == 0) {
//      Service.infoRequest("/index", "get", user);
//      model.addAttribute("user", new User(""));
//      return "registerform";
//    } else {
//      return "index";
//    }
//  }

  // @PostMapping(value={"/","/"})

   @Autowired
   User user;

  @Autowired
  UserRepo userRepo;
  @Autowired
  MessageRepo messageRepo;

  @GetMapping("/")
  public String register(Model model) {
    if (userRepo.count() == 0) {
      Service.infoRequest("/index", "get", user);
      model.addAttribute("user", new User(""));
      return "registerform";
    } else {
      model.addAttribute("username", userRepo.findOne(1L).getUsername());
      return "index";
    }
  }

  @PostMapping("/enter")
  public String submitRegister(User guestuser, Model model) {
    if (guestuser.getUsername().isEmpty()) {
      Service.infoRequest("/enter", "post", user);
      model.addAttribute("user", new User());
      return "registerform";
    } else if (userRepo.findByUsername(guestuser.getUsername()).size() != 0) {
      System.out.println("USER EXISTTTTTTTTTTTTTTTTTTTTTTTTT");
      return "database";
    } else  {
      userRepo.save(guestuser);
      Service.infoRequest("/enter", "post", guestuser);
      System.out.println("There are " + userRepo.findByUsername(guestuser.getUsername()).size() + " user in database.");
      System.out.println("The username is: " + guestuser.getUsername());
      return "redirect:/";
    }
  }
  @GetMapping("/enter")
  public String submitRegister(){
    return "redirect:/";
  }
}
