package com.example.springsecuritysec3.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomeMsg(){
        return "Welcome to spring security!!";
    }
}
