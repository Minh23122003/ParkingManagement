/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.pojo.Comment;
import com.minh.repository.CommentRepository;
import com.minh.repository.ParkingRepository;
import com.minh.repository.UserRepository;
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
public class CommentRepositoryImplement implements CommentRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository u;
    @Autowired
    private ParkingRepository p;
    
    @Override
    public Comment addOrUpdateComment(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("parkingId"), Integer.parseInt(params.get("parkingId")));
        Predicate p2 = b.equal(root.get("userId"), this.u.getUserByUsername(params.get("username")).getId());
        q.where(b.and(p1, p2));
        Query query = s.createQuery(q);
        if (query.getResultList().size() != 0){
            Comment c = (Comment) query.getSingleResult();
            c.setContent(params.get("content"));
            s.update(c);
            return c;
        }       
        
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

    @Override
    public List<Comment> getComment() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Comment");
        return q.getResultList();
    }

    @Override
    public void addOrUpdate(Comment c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() != null) {
            s.update(c);
        } else {
            s.save(c);
        }
    }

    @Override
    public void deleteComment(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Comment comment = this.getCommentById(id);
        s.delete(comment);
    }
    
}
