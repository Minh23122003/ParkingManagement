/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.OrderDetail;
import com.minh.repository.OrderDetailRepository;
import java.util.List;
import javax.persistence.Query;
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
public class OrderDetailRepositoryImplement implements OrderDetailRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<OrderDetail> getOrderDetail() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From OrderDetail");
        return q.getResultList();
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(OrderDetail.class, id);
    }

    @Override
    public void addOrUpdate(OrderDetail o) {
        Session s = this.factory.getObject().getCurrentSession();
        if (o.getId() != null) {
            s.update(o);
        } else {
            s.save(o);
        }
    }

    @Override
    public void deleteOrderDetail(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        OrderDetail orderDetail = this.getOrderDetailById(id);
        s.delete(orderDetail);
    }
    
}
