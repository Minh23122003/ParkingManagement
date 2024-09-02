/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import java.util.List;

/**
 *
 * @author PC
 */
public interface StatsService {
    List<Object[]> statsRevenueByParking();
    List<Object[]> statsRevenueByUser();
    List<Object[]> statsRenenueByMonth(int month, int year);
    List<Object[]> statsRevenueByYear(int year);
    List<Object[]> statsRevenueByPeriod(String startTime, String endTime);
}
