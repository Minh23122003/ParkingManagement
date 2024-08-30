/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Parking;
import com.minh.service.ParkingService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ApiParkingController {
    @Autowired
    private ParkingService parkingService;
    
    @DeleteMapping("/parking/{parkingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "parkingId") int id) {
        this.parkingService.deleteParking(id);
    }
    
    @GetMapping("/parkings")
    public ResponseEntity<List<Parking>> list(@RequestParam Map<String, String> params) {
        List<Parking> parkings = this.parkingService.getParkings(params);
        
        return new ResponseEntity<>(parkings, HttpStatus.OK);
    }
}
