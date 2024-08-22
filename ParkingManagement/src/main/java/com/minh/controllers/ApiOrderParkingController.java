/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.OrderParking;
import com.minh.service.OrderParkingService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiOrderParkingController {
    @Autowired
    private OrderParkingService orderParkingService;
    
    @PostMapping(path="/orderParking", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderParking> addOrder(@RequestParam Map<String, String> params) {
        OrderParking order = this.orderParkingService.addOrder(params);
        
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    
    @GetMapping(path="/orderParking", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<OrderParking>> list(@RequestParam Map<String, String> params){
        List<OrderParking> orders = this.orderParkingService.getOrder(params);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
