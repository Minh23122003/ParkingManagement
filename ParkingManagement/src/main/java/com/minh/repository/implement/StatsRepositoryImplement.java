/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.OrderParking;
import com.minh.pojo.Parking;
import com.minh.pojo.User;
import com.minh.repository.StatsRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class StatsRepositoryImplement implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Object[]> statsRevenueByParking() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rP = q.from(Parking.class);
        Root rO = q.from(OrderParking.class);
        
        q.where(b.equal(rP.get("id"), rO.get("parkingId")), b.like(rO.get("status"), "Đã thanh toán"));
        
        q.multiselect(rP.get("id"), rP.get("address"), b.sum(rO.get("total")), b.count(rO));
        q.groupBy(rP.get("id"));
        Query query = s.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> statsRevenueByUser() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rU = q.from(User.class);
        Root rO = q.from(OrderParking.class);
        
        q.where(b.equal(rU.get("id"), rO.get("userId")));
        
        q.multiselect(rU.get("id"), rU.get("username"), b.sum(rO.get("total")), b.count(rO));
        q.groupBy(rU.get("id"));
        Query query = s.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> statsRenenueByMonth(int month, int year) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rO = q.from(OrderParking.class);
        Root rP = q.from(Parking.class);
        
        q.where(b.equal(rP.get("id"), rO.get("parkingId")), b.like(rO.get("status"), "Đã thanh toán"),
                b.equal(b.function("MONTH", Integer.class, rO.get("createdDate")), month),
                b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), year));
        
        q.multiselect(rP.get("id"), rP.get("address"), b.sum(rO.get("total")), b.count(rO));
        
        q.groupBy(rP.get("id"));
        Query query = s.createQuery(q);
        
        return query.getResultList();
        
        
    }

    @Override
    public List<Object[]> statsRevenueByYear(int year) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rO = q.from(OrderParking.class);
        Root rP = q.from(Parking.class);
        
        q.where(b.equal(rP.get("id"), rO.get("parkingId")), b.like(rO.get("status"), "Đã thanh toán"),
                b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), year));
        
        q.multiselect(rP.get("id"), rP.get("address"), b.sum(rO.get("total")), b.count(rO));
        
        q.groupBy(rP.get("id"));
        q.orderBy(b.asc(b.sum(rO.get("total"))));
        Query query = s.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> statsRevenueByPeriod(String startTime, String endTime) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rO = q.from(OrderParking.class);
        Root rP = q.from(Parking.class);
        Date sT = null;
        Date eT = null;
        try {
            sT = formatter.parse(startTime);
            eT = formatter.parse(endTime);
        } catch (ParseException ex) {
            Logger.getLogger(StatsRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        q.where(b.equal(rP.get("id"), rO.get("parkingId")), b.like(rO.get("status"), "Đã thanh toán"),
                b.greaterThanOrEqualTo(rO.get("createdDate"), sT),
                b.lessThanOrEqualTo(rO.get("createdDate"), eT));
        
        q.multiselect(rP.get("id"), rP.get("address"), b.sum(rO.get("total")), b.count(rO));
        
        q.groupBy(rP.get("id"));
        q.orderBy(b.desc(b.sum(rO.get("total"))));
        Query query = s.createQuery(q);
        
        return query.getResultList();
    }
    
}
