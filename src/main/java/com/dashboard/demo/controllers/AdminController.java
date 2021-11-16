/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.controllers;

import com.dashboard.demo.model.Admin;
import com.dashboard.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author awa.keita
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dashboard")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    
    @ResponseBody
    @GetMapping("/verifierAuth/{login}/{password}")
    public Admin verifieAuth(
            @PathVariable("login") String login,
            @PathVariable("password") String password){
        return this.adminRepository.findByLoginAndPassword(login, password);
        
    }
    
}
