/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.repositories;

import com.dashboard.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author awa.keita
 */
public interface AdminRepository extends JpaRepository <Admin, Integer>{
    Admin findByLoginAndPassword(String login, String password);
    
}
