package hu.greenfox.ramin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class WebController {

  @GetMapping("")
  public String home(){
    System.out.println(LocalDate.now().toString() + " " + LocalTime.now().toString());
    return "index";
  }

 // @PostMapping(value={"/","/"})

  @PostMapping("/register")
  public String register(){
    return "register";
  }

}
