package com.example.internetsale.controller;

import com.example.internetsale.domain.User;
import com.example.internetsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity create (@RequestBody User user){
        if (!checkPasswordLength(user.getPassword())){
            return new ResponseEntity("parol length must be more than 3 words", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkUserName(user.getUserName())){
            return new ResponseEntity("this user already registered", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(user));
    }


    private boolean checkPasswordLength(String password) {
        return password.length() > 3;
    }
}