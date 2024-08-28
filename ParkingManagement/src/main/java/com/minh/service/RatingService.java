/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import com.minh.pojo.Rating;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface RatingService {
    Rating addOrUpdateRating(Map<String, String> params);
    Rating getRatingById(int id);
    List<Rating> getRating();
    void addOrUpdate(Rating r);
    void deleteRating(int id);
}
