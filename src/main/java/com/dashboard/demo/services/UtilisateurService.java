/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.services;

import com.dashboard.demo.model.Profil;
import com.dashboard.demo.model.Utilisateur;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 *
 * @author awa.keita
 */
@Service
public interface UtilisateurService {
    public String ajouterUtilisateur(Utilisateur utilisateur);
    public void modifierUtilisateur(Integer id, Utilisateur utilisateur);
    public String supprimerUtilisateur(Integer id);
    public List<Utilisateur> listeUtilisateur();
    public Utilisateur afficherUtilisateur_by_id(Integer id);
    public Utilisateur verifieConnection(String login, String password);
    List<Utilisateur>findByProfil(Profil type);
    
    
}
