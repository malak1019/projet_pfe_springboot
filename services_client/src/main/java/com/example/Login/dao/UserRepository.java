package com.example.Login.dao;
import com.example.Login.Entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>
{
	 User findByUsernameAndPassword(String username, String password);
}
