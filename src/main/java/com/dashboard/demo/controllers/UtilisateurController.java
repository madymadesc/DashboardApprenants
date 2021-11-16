/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.controllers;

import com.dashboard.demo.model.Profil;
import com.dashboard.demo.model.Utilisateur;
import com.dashboard.demo.model.listePresence;
import com.dashboard.demo.services.PresenceService;
import com.dashboard.demo.services.PresenceServiceImp;
import com.dashboard.demo.services.UtilisateurService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    PresenceService presenceService;
    
    @Autowired
    PresenceServiceImp presenceServiceImp;
    
    @PostMapping("/ajoutUtilisateur")
    public String ajout(@RequestBody Utilisateur utilisateur) {
        return this.utilisateurService.ajouterUtilisateur(utilisateur);
    }
    
    @GetMapping("/getUtilisateurById/{id}")
    public Utilisateur utilisateur(@PathVariable("id") Integer id){
        return utilisateurService.afficherUtilisateur_by_id(id);
    }
    
    @GetMapping("/getAllUtilisateur")
    public List<Utilisateur> liste(){
        return utilisateurService.listeUtilisateur();
    
    }
    
    @PutMapping("/modifyUtilisateur/{id}")
    public void modifier(@RequestBody Utilisateur utilisateur, @PathVariable Integer id){
        this.utilisateurService.modifierUtilisateur(id, utilisateur);
    }
    
    @DeleteMapping("/deleteUtilisateur/{id}")
    public String delete(@PathVariable("id") Integer id){
        return this.utilisateurService.supprimerUtilisateur(id);
    }
    @ResponseBody
    @GetMapping("/verifier/{login}/{password}")
    public Utilisateur verifieConnection(
            @PathVariable("login") String login,
            @PathVariable("password") String password){
        
        return this.utilisateurService.verifieConnection(login, password);
    }
    @GetMapping("/profile={type}")
    public List<Utilisateur>findByProfil(@PathVariable("type")Profil type){
    return utilisateurService.findByProfil(type);
    }
    
    @GetMapping("/Presence")
    public ResponseEntity<List<listePresence>> getAllPresence(){
    List<listePresence> presenceList = presenceServiceImp.getAllPresence();
    return new ResponseEntity<>(presenceList, HttpStatus.OK);
    
    }
    
    @GetMapping("/Presence/Day")
    public List<listePresence> getPresencesList(){
    List<listePresence> PresenceServiceImp;
    return presenceServiceImp.getAllPresenceByDate(LocalDate.now());
    }
    
    @GetMapping("/PresenceDayIs/{jour}")
    public List<listePresence> getPresenceDayIs(
            @PathVariable("jour") 
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jours){
        return presenceServiceImp.getPresenceByDates(jours);
    }
    
  
    @PostMapping("/ajoutPresence")
    public ResponseEntity<listePresence> adduser(@RequestBody listePresence presence){
    listePresence presences = presenceService.ajouterListe(presence);
    return new ResponseEntity<>(presences, HttpStatus.CREATED);
    
    }
    
    @GetMapping("/Presence/interval/{min}&{max}")
    public List<listePresence> Interval(@PathVariable("min") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate min,
            @PathVariable("max") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate max){
        return presenceServiceImp.getPresenceListIntervale(min, max);
    }
        
   @GetMapping("/Presence/{mois}")
    public List<listePresence> getDateByMonth(@PathVariable int mois){
    return presenceServiceImp.getPresenceByMonth(mois);
    }
    @GetMapping("/Presence/week={year}-{months}-{days}")
    public List<listePresence> getListByWeek(
        @PathVariable("year") int year, 
        @PathVariable("months") int months,
        @PathVariable("days") int days
    ){
    return presenceServiceImp.getPresenceByWeek(year, months, days);

    }
}
