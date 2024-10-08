/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.service;

import com.minh.pojo.User;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PC
 */
public interface UserService extends UserDetailsService {
    User getUserByUsername(String username);
    boolean authUser(String username, String password);
    User addUser(Map<String, String> params, MultipartFile avatar);
    List<User> getUser();
    User getUserById(int id);
    void deleteUser(int id);
    void addOrUpdate(User u);
    User updateUser(Map<String, String> params, MultipartFile avatar);
}
