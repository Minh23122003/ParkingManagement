/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import com.minh.pojo.OrderCancel;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface OrderCancelService {
    OrderCancel addOrderCancel(Map<String, String> params);
    OrderCancel getOrderCancelById(int id);
    List<OrderCancel> getOrderCancel();
    void addOrUpdate(OrderCancel o);
    void deleteOrderCancel(int id);
}
