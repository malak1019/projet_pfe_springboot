package com.example.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Login.Entity.Admin;
import com.example.Login.dao.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository userrepo;

    public Admin authenticate(String username, String password) {

        Admin user = userrepo.findByUsernameAndPassword(username, password);
        return user;

    }
}
