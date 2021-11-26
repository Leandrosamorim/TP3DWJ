/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Tp3Java.services;

import com.example.Tp3Java.models.User;
import com.example.Tp3Java.repository.userRepository;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author 55229
 */
@Component
public class UserService {
    
    private userRepository userRepository;
    
    public UserService(userRepository userRepository){
        this.userRepository = userRepository;
    }
    
    //Create
    public User addUser(User user){
        return this.userRepository.save(user);
    }
    
    //Edit
    public User editUser(User user){
        var editedUser = this.userRepository.getById(user.getId());
        editedUser.setEmail(user.getEmail());
        editedUser.setName(user.getName());
        editedUser.setPassword(user.getPassword());
        return this.userRepository.save(editedUser);
    }
    
    //Delete
    public boolean removeUser(Short id){
            this.userRepository.deleteById(id);
            return true;
    }
    
    //GetById
    public User getById(Short id){
        return this.userRepository.getById(id);
    }
    
    //GetByEmail
    public User getByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
    
    //GetAll
    public List<User> getAll(){
        return this.userRepository.findAll();
    }
    
    //Authenticate
    public boolean authenticate(String email, String password) {
        var authUser = this.userRepository.findByEmail(email);
        if (authUser.getPassword() == password) {
            return true;
        } else {
            return false;
        }
    }
    
}
