/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.OrderParking;
import com.minh.repository.OrderParkingRepository;
import com.minh.repository.ParkingRepository;
import com.minh.repository.UserRepository;
import com.minh.repository.implement.ParkingRepositoryImplement;
import com.minh.repository.implement.UserRepositoryImplement;
import com.minh.service.OrderParkingService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class OrderParkingServiceImplement implements OrderParkingService{
    
    @Autowired
    private OrderParkingRepository orderRepo;

    @Override
    public OrderParking addOrder(Map<String, String> params) {
        return this.orderRepo.addOrder(params);
    }

    @Override
    public List<OrderParking> getOrder(Map<String, String> params) {
        return this.orderRepo.getOrder(params);
    }

    @Override
    public void deleteOrderParking(int id) {
        this.orderRepo.deleteOrderParking(id);
    }

    @Override
    public OrderParking getOrderParkingById(int id) {
        return this.orderRepo.getOrderParkingById(id);
    }

    @Override
    public List<OrderParking> getOrder() {
        return this.orderRepo.getOrder();
    }
    
}
