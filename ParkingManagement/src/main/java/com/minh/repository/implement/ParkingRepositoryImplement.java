/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.Parking;
import com.minh.repository.ParkingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class ParkingRepositoryImplement implements ParkingRepository{

    private static final int PAGE_SIZE = 2;
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Parking> getParkings(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Parking> q = b.createQuery(Parking.class);
        Root root = q.from(Parking.class);
        q.select(root);
        
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            
            String address = params.get("address");
            if (address != null && !address.isEmpty()){
                Predicate p1 = b.like(root.get("address"), String.format("%%%s%%", address));
//                q.where(p1);
            }
            
            String minPrice = params.get("minPrice");
            if (minPrice != null && !minPrice.isEmpty()) {
                Predicate p2 = b.or(b.greaterThanOrEqualTo(root.get("dailyPrice"), Double.parseDouble(minPrice)), 
                        b.greaterThanOrEqualTo(root.get("nightPrice"), Double.parseDouble(minPrice)));
//                q.where(p2);
            }

            String maxPrice = params.get("maxPrice");
            if (maxPrice != null && !maxPrice.isEmpty()) {
                Predicate p3 =b.or(b.lessThanOrEqualTo(root.get("dailyPrice"), Double.parseDouble(maxPrice)),
                        b.lessThanOrEqualTo(root.get("nightPrice"), Double.parseDouble(maxPrice)));
//                q.where(p3);
            }
            
            String statusId = params.get("statusId");
            if (statusId != null && !statusId.isEmpty()) {
                Predicate p4 = b.equal(root.get("statusId"), Integer.parseInt(statusId));
//                q.where(p4);
            }
            
            for(int i=0;i<predicates.size();i++){
                q.where(predicates.get(i));
            }
        }
        
        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;

                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }
        return query.getResultList();
    }
    
    @Override
    public Parking getParkingById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Parking.class, id);
    }

    @Override
    public void deleteParking(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Parking p = this.getParkingById(id);
        s.delete(p);
    }

    @Override
    public void addOrUpdate(Parking p) {
        Session s = this.factory.getObject().getCurrentSession();
        if (p.getId() != null) {
            s.update(p);
        } else {
            s.save(p);
        }
    }


    
}
