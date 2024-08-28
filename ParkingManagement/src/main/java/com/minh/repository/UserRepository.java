/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.repository;

import com.minh.pojo.User;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author PC
 */
public interface UserRepository {
    User getUserByUsername(String username);
    boolean authUser(String username, String password);
    User addUser(User user);
    List<User> getUser();
    User getUserById(int id);
    void deleteUser(int id);
    void addOrUpdate(User user);
}
