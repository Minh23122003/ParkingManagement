/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.repository;

import com.minh.pojo.Parking;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface ParkingRepository {
    List<Parking> getParkings(Map<String, String> params);
    void addOrUpdate(Parking p);
    Parking getParkingById(int id);
    void deleteParking(int id);
    List<Parking> getParking();
    
}
