/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.formatters;

import com.minh.pojo.Status;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class StatusFormatter implements Formatter<Status>{

    @Override
    public String print(Status status, Locale locale) {
        return String.valueOf(status.getId());
    }

    @Override
    public Status parse(String statusId, Locale locale) throws ParseException {
        Status s = new Status();
        s.setId(Integer.parseInt(statusId));
        
        return s;
    }
    
}
