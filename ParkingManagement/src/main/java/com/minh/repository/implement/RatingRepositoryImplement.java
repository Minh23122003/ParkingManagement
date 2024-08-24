/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.Rating;
import com.minh.repository.ParkingRepository;
import com.minh.repository.RatingRepository;
import com.minh.repository.UserRepository;
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
public class RatingRepositoryImplement implements RatingRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository u;
    @Autowired
    private ParkingRepository p;
    
    @Override
    public Rating addOrUpdateRating(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Rating> q = b.createQuery(Rating.class);
        Root root = q.from(Rating.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("parkingId"), params.get("parkingId"));
        Predicate p2 = b.equal(root.get("userId"), this.u.getUserByUsername(params.get("username")).getId());
        q.where(p1, p2);
        Query query = s.createQuery(q);
        if (query != null){
            Rating r = (Rating) query.getSingleResult();
            r.setStars(Integer.parseInt(params.get("stars")));
            s.update(r);
            return r;
        }
        Rating r = new Rating();
        r.setStars(Integer.parseInt(params.get("stars")));
        r.setParkingId(this.p.getParkingById(Integer.parseInt(params.get("parkingId"))));
        r.setUserId(this.u.getUserByUsername(params.get("username")));
        s.save(r);
        return r;
    }

    @Override
    public Rating getRatingById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Rating.class, id);
    }
    
}
