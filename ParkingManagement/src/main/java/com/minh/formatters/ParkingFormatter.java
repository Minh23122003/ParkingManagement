/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.formatters;

import com.minh.pojo.Parking;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class ParkingFormatter implements Formatter<Parking>{

    @Override
    public String print(Parking parking, Locale locale) {
        return String.valueOf(parking.getId());
    }

    @Override
    public Parking parse(String parkingId, Locale locale) throws ParseException {
        Parking p = new Parking();
        p.setId(Integer.parseInt(parkingId));
        
        return p;
    }
    
}
