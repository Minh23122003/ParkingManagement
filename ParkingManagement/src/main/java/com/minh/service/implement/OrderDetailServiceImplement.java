/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.OrderDetail;
import com.minh.repository.OrderDetailRepository;
import com.minh.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class OrderDetailServiceImplement implements OrderDetailService{
    @Autowired
    private OrderDetailRepository orderRepo;

    @Override
    public List<OrderDetail> getOrderDetail() {
        return this.orderRepo.getOrderDetail();
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return this.orderRepo.getOrderDetailById(id);
    }

    @Override
    public void addOrUpdate(OrderDetail o) {
        this.orderRepo.addOrUpdate(o);
    }

    @Override
    public void deleteOrderDetail(int id) {
        this.orderRepo.deleteOrderDetail(id);
    }
    
}
