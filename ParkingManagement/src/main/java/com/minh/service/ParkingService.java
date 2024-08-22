/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import com.minh.pojo.Parking;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.Predicate;

/**
 *
 * @author PC
 */
public interface ParkingService {
    List<Parking> getParkings(Map<String, String> params);
    void addOrUpdate(Parking p);
    public Parking getParkingById(int id);
    void deleteParking(int id);
}
