/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.formatters;

import com.minh.pojo.OrderParking;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class OrderParkingFormatter implements Formatter<OrderParking>{

    @Override
    public String print(OrderParking orderParking, Locale locale) {
        return String.valueOf(orderParking.getId());
    }

    @Override
    public OrderParking parse(String orderParkingId, Locale locale) throws ParseException {
        OrderParking o = new OrderParking();
        o.setId(Integer.parseInt(orderParkingId));
        
        return o;
    }
    
}
