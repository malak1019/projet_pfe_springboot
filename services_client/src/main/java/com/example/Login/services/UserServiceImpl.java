package com.example.Login.services;

import com.example.Login.dao.UserRepository;
//import com.example.Login.services.*;
import org.springframework.stereotype.Service;
import com.example.Login.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userrepo;
    
    
    public User authenticate(String username, String password) {
    	
        User user= userrepo.findByUsernameAndPassword(username, password);
        return user;   
        
    }  
    
}

   






















    /*private List<User> users= new ArrayList<>(Arrays.asList(
    		new User(1,"malak","123"),
    		new User(1,"imen","456"),
    		));*/

   /* public User login(String username, String password) {
    	User user = repo.findByUsernameAndPassword(username, password);
		return user;
    	
    }
   /* public LoginMesage loginUser(User userlogin) {
        User user1 = userrepo.findByUsername(userlogin.getUsername());
        if (user1 != null) {
            String password = userlogin.getPassword();
            String storedPassword = user1.getPassword();
            String username = userlogin.getUsername();
            String storedUsername = user1.getUsername();
            
            if (password.equalsIgnoreCase(storedPassword) && username.equalsIgnoreCase(storedUsername)) {
                return new LoginMesage("Login Success", true);
            } else {
                return new LoginMesage("Login Failed", false);
            }
        } else {
            return new LoginMesage("Email not exists", false);
        }
    }

	/*
	 * @Override public String addUser(UserDTO userDTO) { User user = new User(
	 * userDTO.getUserId(), userDTO.getUsername(), userDTO.getEmail(),
	 * userDTO.getPassword() ); userrepo.save(user); // Sauvegarde de l'utilisateur
	 * dans la base de données return "User added successfully"; }
	 */

