/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.Status;
import com.minh.repository.StatusRepository;
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
public class StatusRepositoryImplement implements StatusRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Status> getStatus() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Status");
        return q.getResultList();
    }

    @Override
    public Status getStatusById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Status.class, id);
    }

    @Override
    public void deleteStatus(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Status status = this.getStatusById(id);
        s.delete(status);
    }
    
    @Override
    public void addOrUpdate(Status status) {
        Session s = this.factory.getObject().getCurrentSession();
        if (status.getId() != null) {
            s.update(status);
        } else {
            s.save(status);
        }
    }
    
}
