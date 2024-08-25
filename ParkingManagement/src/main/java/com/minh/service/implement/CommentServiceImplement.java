/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.Comment;
import com.minh.repository.CommentRepository;
import com.minh.service.CommentService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CommentServiceImplement implements CommentService{
    
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addOrUpdateComment(Map<String, String> params) {
        return this.commentRepository.addOrUpdateComment(params);
    }

    @Override
    public Comment getCommentById(int id) {
        return this.commentRepository.getCommentById(id);
    }
    
}
