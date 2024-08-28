/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.User;
import com.minh.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author PC
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    public String createView(Model model) {
        return "user";
    }
    
    @GetMapping("/user/{userId}/update")
    public String detailsView(Model model, @PathVariable(value = "userId") int id){
        model.addAttribute("userDetails", this.userService.getUserById(id));
        return "userDetails";
    }
    
    @GetMapping("/user/add")
    public String addView(Model model){
        model.addAttribute("userDetails", new User());
        return "userDetails";
    }
    
    @PostMapping("/user")
    public String createView(Model model, @ModelAttribute(value = "userDetails") @Valid User u, BindingResult rs) {
//        if (rs.hasErrors())
//            return "userDetails";
        
        try {
            this.userService.addOrUpdate(u);
            
            return "redirect:/user";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "userDetails";
    }
}
