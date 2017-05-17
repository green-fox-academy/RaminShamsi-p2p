package hu.greenfox.ramin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

  @RequestMapping("")
  public String home(){
    return "index";
  }

  @GetMapping("/register")
  public String register(){
    return "register";
  }

}
