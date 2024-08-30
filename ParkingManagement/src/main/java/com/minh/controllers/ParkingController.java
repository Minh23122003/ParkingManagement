/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Parking;
import com.minh.service.ParkingService;
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
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    
    @GetMapping("/parking")
    public String createView(Model model) {
        return "parking";
    }
    
    @PostMapping("/parking")
    public String createView(Model model, @ModelAttribute(value = "parkingDetails") @Valid Parking p, BindingResult rs) {
        if (rs.hasErrors()){
            return "parkingDetails";
        }
            
        try {
            this.parkingService.addOrUpdate(p);
            
            return "redirect:/parking";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex);
        }
        
        return "parkingDetails";
    }
    
    @GetMapping("/parking/{parkingId}/update")
    public String detailsView(Model model, @PathVariable(value = "parkingId") int id){
        model.addAttribute("parkingDetails", this.parkingService.getParkingById(id));
        return "parkingDetails";
    }
    
    @GetMapping("/parking/add")
    public String addView(Model model){
        model.addAttribute("parkingDetails", new Parking());
        return "parkingDetails";
    }
}
