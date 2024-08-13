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
    
    @GetMapping("/parkings")
    public String createView(Model model) {
        model.addAttribute("parking", new Parking());
        return "parkings";
    }
    
    @PostMapping("/parkings")
    public String createView(Model model, @ModelAttribute(value = "parking") @Valid Parking p, BindingResult rs) {
        if (rs.hasErrors())
            return "parkings";
        
        try {
            this.parkingService.addOrUpdate(p);
            
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "parkings";
    }
    
    @GetMapping("/parkings/{parkingId}")
    public String detailsView(Model model, @PathVariable(value = "parkingId") int id){
        model.addAttribute("parking", this.parkingService.getParkingById(id));
        return "parkings";
    }
}
