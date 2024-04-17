package com.blog.controller;

import com.blog.model.User;
import com.blog.service.AdminService;
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
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    private ResponseEntity<User> createUser(@Valid @RequestBody User admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        User registerAdmin = adminService.adminRegister(admin);

        return new ResponseEntity<User>(registerAdmin, HttpStatus.CREATED);
    }
}
