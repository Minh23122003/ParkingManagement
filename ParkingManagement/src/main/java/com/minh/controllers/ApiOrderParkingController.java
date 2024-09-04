/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.OrderDetail;
import com.minh.pojo.OrderParking;
import com.minh.service.OrderDetailService;
import com.minh.service.OrderParkingService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private OrderDetailService orderDetailService;
    private final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    @PostMapping(path="/addOrderParking", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderParking> addOrder(@RequestBody Map<String, String> params) {
        OrderParking order = this.orderParkingService.addOrder(params);
        
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    
    @PostMapping(path="/getOrderParking", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<OrderParking>> list(@RequestBody Map<String, String> params){
        List<OrderParking> orders = this.orderParkingService.getOrder(params);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    
    @DeleteMapping("/orderParking/{orderParkingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "orderParkingId") int id) {
        this.orderParkingService.deleteOrderParking(id);
    }
    
    @PostMapping(path="/pay", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void pay(@RequestBody Map<String, String> params) throws ParseException {
        String listOrder = params.get("listOrder");
        listOrder = listOrder.substring(1, listOrder.length() - 1);
        
        String[] array = listOrder.split(",");
        for (String o : array) {
            OrderParking order = this.orderParkingService.getOrderParkingById(Integer.parseInt(o));
            order.setStatus("Đã thanh toán");
            order.setCreatedDate(formatter.parse(params.get("date")));
            this.orderParkingService.addOrUpdate(order);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setTotal(order.getTotal());
            orderDetail.setMethodPay("Zalo pay");
            orderDetail.setOrderId(order);
            this.orderDetailService.addOrUpdate(orderDetail);
        }
    }
}
