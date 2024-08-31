/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.OrderParking;
import com.minh.pojo.Parking;
import com.minh.repository.StatsRepository;
import java.util.List;
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
public class StatsRepositoryImplement implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> statsRevenueByParking() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootParking = q.from(Parking.class);
        Root rootOrderParking = q.from(OrderParking.class);
        
        q.where(b.equal(rootParking.get("id"), rootOrderParking.get("parkingId")));
        
        q.multiselect(rootParking.get("id"), rootParking.get("address"), b.sum(rootOrderParking.get("total")), b.count(rootOrderParking));
        q.groupBy(rootParking.get("id"));
        Query query = s.createQuery(q);
        
        return query.getResultList();
    }
    
}
