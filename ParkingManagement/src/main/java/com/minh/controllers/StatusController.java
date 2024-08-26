/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Status;
import com.minh.service.StatusService;
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
public class StatusController {
    @Autowired
    private StatusService statusService;
    
    @GetMapping("/status")
    public String createView(Model model) {
        return "status";
    }
    
    @PostMapping("/status")
    public String createView(Model model, @ModelAttribute(value = "statusDetails") @Valid Status s, BindingResult rs) {
        if (rs.hasErrors())
            return "statusDetails";
        
        try {
            this.statusService.addOrUpdate(s);
            
            return "redirect:/status";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "statusDetails";
    }
    
    @GetMapping("/status/{statusId}/update")
    public String detailsView(Model model, @PathVariable(value = "statusId") int id){
        model.addAttribute("statusDetails", this.statusService.getStatusById(id));
        return "statusDetails";
    }
    
    @GetMapping("/status/add")
    public String addView(Model model){
        model.addAttribute("statusDetails", new Status());
        return "statusDetails";
    }
}
