/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Parking;
import com.minh.service.OrderParkingService;
import com.minh.service.ParkingService;
import com.minh.service.StatusService;
import com.minh.service.UserService;
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
    @Autowired
    private UserService userService;
    @Autowired
    private OrderParkingService orderService;
    
    @ModelAttribute
    public void commAttrs(Model model) {
        model.addAttribute("status", statusService.getStatus());
        model.addAttribute("user", this.userService.getUser());
        model.addAttribute("getParking", this.parkingService.getParking());
        model.addAttribute("orderParking", this.orderService.getOrder());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        
        
        model.addAttribute("parkings", this.parkingService.getParkings(params));
        
        return "home";
    }
}
