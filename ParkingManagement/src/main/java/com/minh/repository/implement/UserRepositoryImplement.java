/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.minh.pojo.User;
import com.minh.repository.UserRepository;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class UserRepositoryImplement implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);

        return (User) q.getSingleResult();
        
    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);

        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public User addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(user);

        return user;
    }

    @Override
    public List<User> getUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From User");
        return q.getResultList();
    }

    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        User u = this.getUserById(id);
        s.delete(u);
    }

    @Override
    public void addOrUpdate(User user){
        Session s = this.factory.getObject().getCurrentSession();
        
        if (!user.getFile().isEmpty()){
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
        if (user.getId() != null) {
            s.update(user);
        }
        else {
            user.setPassword(passEncoder.encode(user.getPassword()));
            s.save(user);
        }
    }

    @Override
    public User updateUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(user);
        
        return user;
    }

}
