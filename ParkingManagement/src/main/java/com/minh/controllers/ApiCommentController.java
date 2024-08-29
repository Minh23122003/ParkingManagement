/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Comment;
import com.minh.repository.CommentRepository;
import com.minh.service.CommentService;
import java.util.Map;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    
    @PostMapping(path="/comment", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Comment> addOrUpdateComment(@RequestBody Map<String, String> params) {
        Comment comment = this.commentService.addOrUpdateComment(params);
        
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/comment/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "commentId") int id) {
        this.commentService.deleteComment(id);
    }
}
