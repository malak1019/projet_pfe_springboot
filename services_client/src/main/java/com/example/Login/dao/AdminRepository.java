package com.example.Login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Login.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository <Admin, Integer>{
    Admin findByUsernameAndPassword(String username, String password);   
}
