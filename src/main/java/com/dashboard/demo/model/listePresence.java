/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author awa.keita
 */
@Entity
public class listePresence {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private LocalDate date = LocalDate.now();
    
    private LocalTime arriver = LocalTime.now();
    
    private LocalTime depart;
    
    @ManyToOne
    private Utilisateur user;
    
    public listePresence() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getArriver() {
        return arriver;
    }

    public void setArriver(LocalTime arriver) {
        this.arriver = arriver;
    }

    public LocalTime getDepart() {
        return depart;
    }

    public void setDepart(LocalTime depart) {
        this.depart = depart;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    
    
}
