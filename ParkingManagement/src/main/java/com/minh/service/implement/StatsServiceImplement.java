/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;


import com.minh.repository.StatsRepository;
import com.minh.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class StatsServiceImplement implements StatsService {
    @Autowired
    private StatsRepository statsRepo;

    @Override
    public List<Object[]> statsRevenueByParking() {
        return this.statsRepo.statsRevenueByParking();
    }

    @Override
    public List<Object[]> statsRevenueByPeroid(int year, String peroid) {
        return this.statsRepo.statsRevenueByPeroid(year, peroid);
    }

    
}
