package com.example.springsecuritysec3.controller;


import com.example.springsecuritysec3.model.Customer;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomeMsg(){
        return "Welcome to spring security!!";
    }

    @GetMapping("/")
    public String homePage(){
        return "Welcome to home page";
    }

    //posting registration customer data


}
