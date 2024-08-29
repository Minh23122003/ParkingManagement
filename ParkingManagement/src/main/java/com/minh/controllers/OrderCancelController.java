/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.OrderCancel;
import com.minh.service.OrderCancelService;
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
public class OrderCancelController {
    @Autowired
    private OrderCancelService orderService;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    @GetMapping("/orderCancel")
    public String createView(Model model) {
        model.addAttribute("orderCancel", this.orderService.getOrderCancel());
        return "orderCancel";
    }
    
    @GetMapping("/orderCancel/{orderCancelId}/update")
    public String detailsView(Model model, @PathVariable(value = "orderCancelId") int id){
        model.addAttribute("orderCancelDetails", this.orderService.getOrderCancelById(id));
        return "orderCancelDetails";
    }
    
    @GetMapping("/orderCancel/add")
    public String addView(Model model){
        model.addAttribute("orderCancelDetails", new OrderCancel());
        return "orderCancelDetails";
    }
    
    @PostMapping("/orderCancel")
    public String createView(Model model, @ModelAttribute(value = "orderCancelDetails") @Valid OrderCancel o, BindingResult rs) throws ParseException {
//        if (rs.hasErrors())
//            return "orderParkingDetails";
        
        if (o.getDateTransient()!= null)
            o.setDate(formatter.parse(o.getDateTransient()));
        if (o.getId() != null && o.getDateTransient()== null){
            o.setDate(this.orderService.getOrderCancelById(o.getId()).getDate());
        }

        try {
            this.orderService.addOrUpdate(o);
            
            return "redirect:/orderCancel";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "orderCancelDetails";
    }
}
