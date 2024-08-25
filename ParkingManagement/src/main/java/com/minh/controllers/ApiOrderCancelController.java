/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.OrderCancel;
import com.minh.service.OrderCancelService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiOrderCancelController {
    @Autowired
    private OrderCancelService orderCancelService;
    
    @PostMapping(path="/orderCancel", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderCancel> addOrder(@RequestBody Map<String, String> params) {
        OrderCancel order = this.orderCancelService.addOrderCancel(params);
        
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
