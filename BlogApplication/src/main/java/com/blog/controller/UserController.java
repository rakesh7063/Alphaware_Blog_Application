package com.blog.controller;

import com.blog.model.User;
import com.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> userRegisterHandle(@Valid @RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userRegister = userService.getRegister(user);
        return new ResponseEntity<>(userRegister, HttpStatus.CREATED);
    }
}
