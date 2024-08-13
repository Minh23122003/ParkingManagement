/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.Status;
import com.minh.repository.StatusRepository;
import com.minh.service.StatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class StatusServiceImplement implements StatusService{
    @Autowired
    private StatusRepository statusRepository;
    
    @Override
    public List<Status> getStatus() {
        return this.statusRepository.getStatus();
    }
    
}
