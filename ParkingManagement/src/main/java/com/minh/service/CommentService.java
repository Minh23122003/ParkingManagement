/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import com.minh.pojo.Comment;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface CommentService {
    Comment addComment(Map<String, String> params);
    Comment getCommentById(int id);
}
