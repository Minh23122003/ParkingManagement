/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.pojo.Rating;
import com.minh.service.RatingService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiRatingController {
    @Autowired
    private RatingService ratingService;
    
    @PostMapping(path="/rating", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Rating> addRating(@RequestBody Map<String, String> params) {
        Rating rating = this.ratingService.addOrUpdateRating(params);
        
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/rating/{ratingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "ratingId") int id) {
        this.ratingService.deleteRating(id);
    }
}
