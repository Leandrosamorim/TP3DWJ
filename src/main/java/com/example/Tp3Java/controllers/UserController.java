/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Tp3Java.controllers;

import com.example.Tp3Java.models.User;
import com.example.Tp3Java.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 55229
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public ModelAndView userList(HttpSession session){
        
        var model = new ModelAndView("user_list");
        var users = userService.getAll();
        model.addObject("users", users);
        return model;
    }
    
     @GetMapping("/users/form")
    public String saveUser(){
        return "user_form";
    }
    
     @GetMapping("/usuarios/{id}/form")
    public ModelAndView updateUser(@PathVariable short id){
        var model = new ModelAndView("user_form");
        var user = userService.getById(id);
        model.addObject("user", user);
        return model;
    }
    
     @PostMapping("/users/{id}/update")
    public String updateUser(@PathVariable short id, User newUser){
        var user = userService.editUser(newUser);
        return "redirect:/users";
    }
    
    @PostMapping("/users/create")
    public ModelAndView saveUser(User user){
        var model = new ModelAndView("user_list");
        var msg = userService.addUser(user);
        model.addObject("msg", msg);
        model.addObject("users", userService.getAll());
        return model; // nome de uma página jsp webapp/WEB_INF/jsp/lista_usuarios.jsp
    }
    
     @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable short id){
        var deleted = userService.removeUser(id);
        return "redirect:/users";
    }
    
    @GetMapping("/users/{id}/show")
    public ModelAndView showUser(@PathVariable short id){
        var model = new ModelAndView("user");
        var user = userService.getById(id);
        model.addObject("user", user);
        return model;
    }
    

}
