/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.Rating;
import com.minh.repository.RatingRepository;
import com.minh.service.RatingService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class RatingServiceImplement implements RatingService{

    @Autowired
    private RatingRepository RatingRepository;
    
    @Override
    public Rating addOrUpdateRating(Map<String, String> params) {
        return this.RatingRepository.addOrUpdateRating(params);
    }

    @Override
    public Rating getRatingById(int id) {
        return this.RatingRepository.getRatingById(id);
    }
    
}
