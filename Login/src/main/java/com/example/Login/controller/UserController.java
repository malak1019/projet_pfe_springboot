package com.example.Login.controller;

import com.example.Login.Entity.User;
import com.example.Login.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth1")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        User oauthUser = userService.authenticate(user.getUsername(), user.getPassword());

        Map<String, String> response = new HashMap<>();
        if (oauthUser != null) {
            response.put("message", "Login successful!");
            response.put("username", oauthUser.getUsername());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
