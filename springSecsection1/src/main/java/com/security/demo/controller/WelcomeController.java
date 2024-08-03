package com.security.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {

    @GetMapping("/")
    public String welcome(){

        return "welcome to spring application without spring secuirty"  ;
    }

    @GetMapping("/private")
    public String messagePrivate(){
        return "only authorized can access this message";
    }

    @GetMapping("/public")
    public String messagePublic(){
        return "this messsage is avialbel for everyone";
    }
}
