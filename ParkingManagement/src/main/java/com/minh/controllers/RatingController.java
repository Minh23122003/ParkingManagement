/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Rating;
import com.minh.service.RatingService;
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
public class RatingController {
    @Autowired
    private RatingService ratingService;
    
    @GetMapping("/rating")
    public String createView(Model model) {
        model.addAttribute("rating", this.ratingService.getRating());
        return "rating";
    }
    
    @PostMapping("/rating")
    public String createView(Model model, @ModelAttribute(value = "ratingDetails") @Valid Rating r, BindingResult rs) {
        if (rs.hasErrors())
            return "ratingDetails";
        
        try {
            this.ratingService.addOrUpdate(r);
            
            return "redirect:/rating";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "ratingDetails";
    }
    
    @GetMapping("/rating/{ratingId}/update")
    public String detailsView(Model model, @PathVariable(value = "ratingId") int id){
        model.addAttribute("ratingDetails", this.ratingService.getRatingById(id));
        return "ratingDetails";
    }
    
    @GetMapping("/rating/add")
    public String addView(Model model){
        model.addAttribute("ratingDetails", new Rating());
        return "ratingDetails";
    }
}
