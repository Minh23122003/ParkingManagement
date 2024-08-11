/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.Parking;
import com.minh.repository.ParkingRepository;
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
public class ParkingRepositoryImplement implements ParkingRepository{

    private static final int PAGE_SIZE = 4;
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Parking> getParkings(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Parking> q = b.createQuery(Parking.class);
        Root root = q.from(Parking.class);
        q.select(root);
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
