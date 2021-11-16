/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author awa.keita
 */
@Entity
public class Admin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Admin;

    private String nom;

    private String prenom;
    
    private String email;
    
    private String login;

    private String password;
    
    @Enumerated(EnumType.STRING)
    private UtilisateurStatus status;
    
     public Admin() {
    }
    
    

    public Integer getId_Admin() {
        return id_Admin;
    }

    public void setId(Integer id) {
        this.id_Admin = id_Admin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
