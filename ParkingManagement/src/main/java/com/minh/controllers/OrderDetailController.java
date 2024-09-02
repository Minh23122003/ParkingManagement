/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.OrderDetail;
import com.minh.service.OrderDetailService;
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
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    
    @GetMapping("/orderDetail")
    public String createView(Model model) {
        model.addAttribute("orderDetail", this.orderDetailService.getOrderDetail());
        return "orderDetail";
    }
    
    @PostMapping("/orderDetail")
    public String createView(Model model, @ModelAttribute(value = "orderDetailDetails") @Valid OrderDetail o, BindingResult rs) {
        if (rs.hasErrors())
            return "orderDetailDetails";
        
        try {
            this.orderDetailService.addOrUpdate(o);
            
            return "redirect:/orderDetail";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "orderDetailDetails";
    }
    
    @GetMapping("/orderDetail/{orderDetailId}/update")
    public String detailsView(Model model, @PathVariable(value = "orderDetailId") int id){
        model.addAttribute("orderDetailDetails", this.orderDetailService.getOrderDetailById(id));
        return "orderDetailDetails";
    }
    
    @GetMapping("/orderDetail/add")
    public String addView(Model model){
        model.addAttribute("orderDetailDetails", new OrderDetail());
        return "orderDetailDetails";
    }
}
