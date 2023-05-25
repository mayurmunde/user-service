package com.example.userservice.controller;

import com.example.userservice.Model.User;
import com.example.userservice.exception.UserServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/test")
    public String test() {
        return "test success";
    }

    @GetMapping("/demo/{test}")
    public String demo(@PathVariable String test) {
        return "demo success "+ test;
    }

    @GetMapping("/test/exe")
    public ResponseEntity<User> exe(){
        if(true)
            throw new UserServiceException("as");
        return ResponseEntity.ok().build();
    }

}
