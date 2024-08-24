/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import com.minh.pojo.OrderParking;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface OrderParkingService {
    OrderParking addOrder(Map<String, String> params);
    List<OrderParking> getOrder(Map<String, String> params);
    void deleteOrderParking(int id);
    OrderParking getOrderParkingById(int id);
}
