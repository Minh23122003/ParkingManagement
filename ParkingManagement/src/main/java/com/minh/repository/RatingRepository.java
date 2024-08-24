/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.repository;

import com.minh.pojo.Rating;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface RatingRepository {
    Rating addOrUpdateRating(Map<String, String> params);
    Rating getRatingById(int id);
}
