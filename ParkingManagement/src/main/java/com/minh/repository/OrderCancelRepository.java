/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.repository;

import com.minh.pojo.OrderCancel;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface OrderCancelRepository {
    OrderCancel addOrderCancel(Map<String, String> params);
    OrderCancel getOrderCancelById(int id);
}
