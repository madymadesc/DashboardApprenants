/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.repositories;

import com.dashboard.demo.model.Profil;
import com.dashboard.demo.model.Utilisateur;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author awa.keita
 */
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer>{
    
    Utilisateur findByLoginAndPassword(String login, String password);
    List<Utilisateur>findByProfil(@Param("type")Profil type);
    
    
}
