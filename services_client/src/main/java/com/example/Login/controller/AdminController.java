package com.example.Login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login.Entity.Admin;
import com.example.Login.services.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth2")
public class AdminController {
    @Autowired
    private AdminService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Admin user) {
        Admin oauthUser = userService.authenticate(user.getUsername(), user.getPassword());

        Map<String, String> response = new HashMap<>();
        if (oauthUser != null) {
            // Pass the User object instead of the username string
            // String token = jwtUtil.generateToken(oauthUser);
            response.put("message", "Login successful!");
            response.put("username", oauthUser.getUsername());
            // response.put("token", token); // Return the token
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
