/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.Rating;
import com.minh.repository.RatingRepository;
import com.minh.service.RatingService;
import java.util.List;
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

    @Override
    public List<Rating> getRating() {
        return this.RatingRepository.getRating();
    }

    @Override
    public void addOrUpdate(Rating r) {
        this.RatingRepository.addOrUpdate(r);
    }

    @Override
    public void deleteRating(int id) {
        this.RatingRepository.deleteRating(id);
    }
    
}
