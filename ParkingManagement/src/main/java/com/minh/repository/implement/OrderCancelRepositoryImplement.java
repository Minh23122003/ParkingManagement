/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.OrderCancel;
import com.minh.repository.OrderCancelRepository;
import com.minh.repository.OrderParkingRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class OrderCancelRepositoryImplement implements OrderCancelRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private OrderParkingRepository orderParkingRepo;
    private final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    @Override
    public OrderCancel addOrderCancel(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        
        OrderCancel order = new OrderCancel();
        order.setAccountNumber(params.get("accountNumber"));
        order.setReason(params.get("reason"));
        order.setBankName(params.get("bankName"));
        order.setStatus(params.get("status"));
        order.setOrderId(this.orderParkingRepo.getOrderParkingById(Integer.parseInt(params.get("orderId"))));
        try {
            order.setDate(formatter.parse(params.get("date")));
        } catch (ParseException ex) {
            Logger.getLogger(OrderCancelRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.save(order);
        return order;
    }

    @Override
    public OrderCancel getOrderCancelById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(OrderCancel.class, id);
    }
    
}
