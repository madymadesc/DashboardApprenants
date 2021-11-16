/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.services;

import com.dashboard.demo.model.Profil;
import com.dashboard.demo.model.Utilisateur;
import com.dashboard.demo.repositories.UtilisateurRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author awa.keita
 */
@Service
public class UtilisateurServiceImp implements UtilisateurService{
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public String ajouterUtilisateur(Utilisateur utilisateur) {
        this.utilisateurRepository.save(utilisateur);
        return "Ajout effectuer avec succes:"+utilisateur.getPrenom(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void modifierUtilisateur(Integer id, Utilisateur utilisateur) {
        Utilisateur utilisateurExistant = utilisateurRepository.findById(id).get();
        utilisateurExistant.setNom(utilisateur.getNom());
        utilisateurExistant.setPrenom(utilisateur.getPrenom());
        utilisateurExistant.setAge(utilisateur.getAge());
        utilisateurExistant.setGenre(utilisateur.getGenre());
        utilisateurExistant.setEmail(utilisateur.getEmail());
        utilisateurExistant.setLogin(utilisateur.getLogin());
        utilisateurExistant.setPassword(utilisateur.getPassword());
        utilisateurExistant.setTelephone(utilisateur.getTelephone());
        utilisateurExistant.setStatus_utilisateur(utilisateur.getStatus_utilisateur());
        utilisateurExistant.setDateCreation(utilisateur.getDateCreation());
        utilisateurExistant.setDateModification(utilisateur.getDateModification());
    }

    @Override
    public String supprimerUtilisateur(Integer id) {
        this.utilisateurRepository.deleteById(id);
        return "L'utilisateur vient d'être supprimer avec succes"; //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur afficherUtilisateur_by_id(Integer id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public Utilisateur verifieConnection(String login, String password) {
        Utilisateur verifie = utilisateurRepository.findByLoginAndPassword(login, password);
            
        return verifie; 
    }    

    @Override
    public List<Utilisateur> findByProfil(Profil type) {
        return utilisateurRepository.findByProfil(type);
    }
    
}
