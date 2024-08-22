/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.OrderParking;
import com.minh.repository.OrderParkingRepository;
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
    private UserRepositoryImplement u;
    private ParkingRepositoryImplement r;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private OrderParkingRepository orderRepo;

    @Override
    public OrderParking addOrder(Map<String, String> params) {
        OrderParking o = new OrderParking();
        o.setVehicleName(params.get("vihicleName"));
        o.setLicensePlates(params.get("licensePlates"));
        o.setStatus(params.get("status"));
        try {
            o.setCreatedDate(formatter.parse(params.get("createdDate")));
            o.setStartTime(formatter.parse(params.get("startTime")));
            o.setEndTime(formatter.parse(params.get("endTime")));
        } catch (ParseException ex) {
            Logger.getLogger(OrderParkingServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        o.setUserId(this.u.getUserByUsername(params.get("username")));
        o.setParkingId(this.r.getParkingById(Integer.parseInt(params.get("parkingId"))));
        
        return o;
    }

    @Override
    public List<OrderParking> getOrder(Map<String, String> params) {
        return this.orderRepo.getOrder(params);
    }
    
}
