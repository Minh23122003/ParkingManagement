/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

import com.minh.service.StatsService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
public class StatsController {
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/stats")
    public String stats(Model model) {
        return "stats";
    }
    
    @GetMapping("/statsByParking")
    public String statsByParking(Model model) {
        model.addAttribute("statsByParking", this.statsService.statsRevenueByParking());
        
        return "statsByParking";
    }
    
    @GetMapping("/statsByUser")
    public String statsByUser(Model model) {
        model.addAttribute("statsByUser", this.statsService.statsRevenueByUser());
        
        return "statsByUser";
    }
    
    @GetMapping("/statsByMonth")
    public String statsByMonth(Model model, @RequestParam Map<String, String> params) {
        if (params.isEmpty() || params.get("month") == "") {
            model.addAttribute("statsByMonth", "");
        } else {
            String a = params.get("month");
            int year = Integer.parseInt(a.substring(0, 4));
            int month = Integer.parseInt(a.substring(5));
            model.addAttribute("statsByMonth", this.statsService.statsRenenueByMonth(month, year));
        }
        
        return "statsByMonth";
    }
    
    @GetMapping("/statsByYear")
    public String statsByYear(Model model, @RequestParam Map<String, String> params) {
        if (params.isEmpty() || params.get("year") == "") {
            model.addAttribute("statsByYear", "");
        } else {
            String a = params.get("year");
            int year = Integer.parseInt(a);
            model.addAttribute("statsByYear", this.statsService.statsRevenueByYear(year));
        }
        
        return "statsByYear";
    }
    
    @GetMapping("/statsByPeriod")
    public String statsByPeriod(Model model, @RequestParam Map<String, String> params) {
        if (params.isEmpty() || params.get("startTime") == "" || params.get("endTime") == "") {
            model.addAttribute("statsByPeriod", "");
        } else {
            String startTime = params.get("startTime");
            String endTime = params.get("endTime");
            model.addAttribute("statsByPeriod", this.statsService.statsRevenueByPeriod(startTime, endTime));
        }
        
        return "statsByPeriod";
    }
}
