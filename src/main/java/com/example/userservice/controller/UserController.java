package com.example.userservice.controller;

import com.example.userservice.Model.User;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable int id){
        return userService.findUsers(id);
    }

    @PostMapping("/users/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }


}
