/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.OrderParking;
import com.minh.repository.OrderParkingRepository;
import com.minh.repository.ParkingRepository;
import com.minh.repository.UserRepository;
import com.minh.service.implement.OrderParkingServiceImplement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class OrderParkingRepositoryImplement implements OrderParkingRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository u;
    @Autowired
    private ParkingRepository r;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public OrderParking addOrder(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        OrderParking o = new OrderParking();
        o.setVehicleName(params.get("vehicleName"));
        o.setLicensePlates(params.get("licensePlates"));
        o.setStatus(params.get("status"));
        try {
            o.setCreatedDate(formatter.parse(params.get("createdDate")));
            o.setStartTime(formatter.parse(params.get("startTime")));
            o.setEndTime(formatter.parse(params.get("endTime")));
        } catch (ParseException ex) {
            Logger.getLogger(OrderParkingServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        o.setUserId(this.u.getUserByUsername(params.get("username")));
        o.setParkingId(this.r.getParkingById(Integer.parseInt(params.get("parkingId"))));
        o.setTotal(Integer.parseInt(params.get("total")));
        s.save(o);
        return o;
    }

    @Override
    public List<OrderParking> getOrder(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<OrderParking> q = b.createQuery(OrderParking.class);
        Root root = q.from(OrderParking.class);
        q.select(root);
        
        String userId = params.get("userId");
        if(userId != null)
            q.where(b.equal(root.get("userId"), Integer.parseInt(userId)));
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void deleteOrderParking(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        OrderParking o = this.getOrderParkingById(id);
        s.delete(o);
    }

    @Override
    public OrderParking getOrderParkingById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(OrderParking.class, id);
    }
    
}
