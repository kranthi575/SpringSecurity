package com.example.springsecuritysec3.controller;

import com.example.springsecuritysec3.model.Customer;
import com.example.springsecuritysec3.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepo customerRepo;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){

        System.out.println("/register called for registering user");
        System.out.println("Customer details : "+customer.toString());
    try {
        String hashpwd = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashpwd);

        Customer customerSave = customerRepo.save(customer);

        if (customerSave.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("USER REGISTERED SUCCESSFULLY");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR IN CREATING USER");
        }
    }
    catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error : "+e.getMessage());
    }

    }

}
