/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.service.ParkingService;
import com.minh.service.StatusService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private StatusService statusService;
    
    @ModelAttribute
    public void commAttrs(Model model) {
        model.addAttribute("status", statusService.getStatus());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        
        
        model.addAttribute("parkings", this.parkingService.getParkings(params));
        
        return "home";
    }
    
}
