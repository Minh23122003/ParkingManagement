/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.OrderCancel;
import com.minh.repository.OrderCancelRepository;
import com.minh.service.OrderCancelService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class OrderCancelServiceImplement implements OrderCancelService{

    @Autowired
    private OrderCancelRepository orderCancelRepo;
    
    @Override
    public OrderCancel addOrderCancel(Map<String, String> params) {
        return this.orderCancelRepo.addOrderCancel(params);
    }

    @Override
    public OrderCancel getOrderCancelById(int id) {
        return this.orderCancelRepo.getOrderCancelById(id);
    }

    @Override
    public List<OrderCancel> getOrderCancel() {
        return this.orderCancelRepo.getOrderCancel();
    }

    @Override
    public void addOrUpdate(OrderCancel o) {
        this.orderCancelRepo.addOrUpdate(o);
    }

    @Override
    public void deleteOrderCancel(int id) {
        this.orderCancelRepo.deleteOrderCancel(id);
    }
    
}
