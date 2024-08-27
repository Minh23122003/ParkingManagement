/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.service.OrderParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author PC
 */
@Controller
public class OrderParkingController {
    @Autowired
    private OrderParkingService orderService;
    
    @GetMapping("/orderParking")
    public String createView(Model model) {
        model.addAttribute("orderParking", this.orderService.getOrder());
        return "orderParking";
    }
}
