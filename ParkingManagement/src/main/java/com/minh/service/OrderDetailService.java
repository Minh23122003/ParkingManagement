/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import com.minh.pojo.OrderDetail;
import java.util.List;

/**
 *
 * @author PC
 */
public interface OrderDetailService {
    List<OrderDetail> getOrderDetail();
    OrderDetail getOrderDetailById(int id);
    void addOrUpdate(OrderDetail o);
    void deleteOrderDetail(int id);
}
