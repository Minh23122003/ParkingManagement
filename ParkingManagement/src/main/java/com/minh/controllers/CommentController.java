/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Comment;
import com.minh.service.CommentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author PC
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/comment")
    public String createView(Model model) {
        model.addAttribute("comment", this.commentService.getComment());
        return "comment";
    }
    
    @PostMapping("/comment")
    public String createView(Model model, @ModelAttribute(value = "commentDetails") @Valid Comment c, BindingResult rs) {
        if (rs.hasErrors())
            return "commentDetails";
        
        try {
            this.commentService.addOrUpdate(c);
            
            return "redirect:/comment";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "commentDetails";
    }
    
    @GetMapping("/comment/{commentId}/update")
    public String detailsView(Model model, @PathVariable(value = "commentId") int id){
        model.addAttribute("commentDetails", this.commentService.getCommentById(id));
        return "commentDetails";
    }
    
    @GetMapping("/comment/add")
    public String addView(Model model){
        model.addAttribute("commentDetails", new Comment());
        return "commentDetails";
    }
}
