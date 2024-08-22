/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.OrderParking;
import com.minh.repository.OrderParkingRepository;
import java.util.List;
import java.util.Map;
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
    
    @Override
    public void addOrder(OrderParking o) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(o);
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
            q.where(b.equal(root.get("userId"), userId));
        Query query = s.createQuery(q);
        return query.getResultList();
    }
    
}
