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

    private static final int PAGE_SIZE = 4;
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private ParkingRepository parkingRepo;
    
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
                predicates.add(p1);
            }
            
            String minPriceDay = params.get("minPriceDay");
            if (minPriceDay != null && !minPriceDay.isEmpty()) {
                Predicate p2 = b.greaterThanOrEqualTo(root.get("dailyPrice"), Double.parseDouble(minPriceDay));
                predicates.add(p2);
            }
            
            String minPriceNight = params.get("minPriceNight");
            if (minPriceNight != null && !minPriceNight.isEmpty()) {
                Predicate p3 = b.greaterThanOrEqualTo(root.get("nightPrice"), Double.parseDouble(minPriceNight));
                predicates.add(p3);
            }

            String maxPriceDay = params.get("maxPriceDay");
            if (maxPriceDay != null && !maxPriceDay.isEmpty()) {
                Predicate p4 =b.lessThanOrEqualTo(root.get("dailyPrice"), Double.parseDouble(maxPriceDay));
                predicates.add(p4);
            }

            String maxPriceNight = params.get("maxPriceNight");
            if (maxPriceNight != null && !maxPriceNight.isEmpty()) {
                Predicate p5 =b.lessThanOrEqualTo(root.get("nightPrice"), Double.parseDouble(maxPriceNight));
                predicates.add(p5);
            }
            
            String statusId = params.get("statusId");
            if (statusId != null && !statusId.isEmpty()) {
                Predicate p6 = b.equal(root.get("statusId"), Integer.parseInt(statusId));
                predicates.add(p6);
            }
            q.where(predicates.toArray(new Predicate[0]));
        }
        
        Query query = s.createQuery(q);
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
