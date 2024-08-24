/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.Comment;
import com.minh.repository.CommentRepository;
import com.minh.repository.ParkingRepository;
import com.minh.repository.UserRepository;
import java.util.Map;
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
public class CommentRepositoryImplement implements CommentRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository u;
    @Autowired
    private ParkingRepository p;
    
    @Override
    public Comment addComment(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setContent(params.get("content"));
        c.setParkingId(this.p.getParkingById(Integer.parseInt(params.get("parkingId"))));
        c.setUserId(this.u.getUserByUsername(params.get("username")));
        s.save(c);
        return c;
    }

    @Override
    public Comment getCommentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Comment.class, id);
    }
    
}
