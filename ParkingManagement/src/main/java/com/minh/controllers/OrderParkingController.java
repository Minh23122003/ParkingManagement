/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.OrderParking;
import com.minh.service.OrderParkingService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class OrderParkingController {
    @Autowired
    private OrderParkingService orderService;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    @GetMapping("/orderParking")
    public String createView(Model model) {
        model.addAttribute("orderParking", this.orderService.getOrder());
        return "orderParking";
    }
    
    @GetMapping("/orderParking/{orderParkingId}/update")
    public String detailsView(Model model, @PathVariable(value = "orderParkingId") int id){
        model.addAttribute("orderParkingDetails", this.orderService.getOrderParkingById(id));
        return "orderParkingDetails";
    }
    
    @GetMapping("/orderParking/add")
    public String addView(Model model){
        model.addAttribute("orderParkingDetails", new OrderParking());
        return "orderParkingDetails";
    }
    
    @PostMapping("/orderParking")
    public String createView(Model model, @ModelAttribute(value = "orderParkingDetails") @Valid OrderParking o, BindingResult rs) throws ParseException {
//        if (rs.hasErrors())
//            return "orderParkingDetails";
        
        if (o.getCreatedDateTransient() != null)
            o.setCreatedDate(formatter.parse(o.getCreatedDateTransient()));
        if (o.getStartTimeTransient() != null)
            o.setStartTime(formatter.parse(o.getStartTimeTransient()));
        if (o.getEndTimeTransient() != null)
            o.setEndTime(formatter.parse(o.getEndTimeTransient()));

        try {
            this.orderService.addOrUpdate(o);
            
            return "redirect:/orderParking";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "orderParkingDetails";
    }
}
