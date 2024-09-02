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
 * @author PC
 */
@Service
public class StatsServiceImplement implements StatsService{
    @Autowired
    private StatsRepository statsRepo;

    @Override
    public List<Object[]> statsRevenueByParking() {
        return this.statsRepo.statsRevenueByParking();
    }

    @Override
    public List<Object[]> statsRevenueByUser() {
        return this.statsRepo.statsRevenueByUser();
    }

    @Override
    public List<Object[]> statsRenenueByMonth(int month, int year) {
        return this.statsRepo.statsRenenueByMonth(month, year);
    }

    @Override
    public List<Object[]> statsRevenueByYear(int id) {
        return this.statsRepo.statsRevenueByYear(id);
    }

    @Override
    public List<Object[]> statsRevenueByPeriod(String startTime, String endTime) {
        return this.statsRepo.statsRevenueByPeriod(startTime, endTime);
    }
    
}
