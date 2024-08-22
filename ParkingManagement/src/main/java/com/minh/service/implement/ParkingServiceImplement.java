/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.Parking;
import com.minh.repository.ParkingRepository;
import com.minh.service.ParkingService;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ParkingServiceImplement implements ParkingService{

    @Autowired
    private ParkingRepository parkingRepo;
    
    @Override
    public List<Parking> getParkings(Map<String, String> params) {
        return this.parkingRepo.getParkings(params);
    }

    @Override
    public void addOrUpdate(Parking p) {
        this.parkingRepo.addOrUpdate(p);
    }

    @Override
    public Parking getParkingById(int id) {
        return this.parkingRepo.getParkingById(id);
    }

    @Override
    public void deleteParking(int id) {
        this.parkingRepo.deleteParking(id);
    }

    
}
