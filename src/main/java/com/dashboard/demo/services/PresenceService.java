/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.services;

import com.dashboard.demo.model.listePresence;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author awa.keita
 */
public interface PresenceService {
    
    listePresence ajouterListe(listePresence presence);
    
    void supprimerListe(listePresence presence);
    
    List<listePresence> getAllPresence();
    
    List<listePresence> getAllPresenceByDate(LocalDate jour);
    
    List<listePresence> getPresenceByDates(LocalDate days);
    
    List<listePresence> getPresenceListIntervale(LocalDate min, LocalDate max);
    
    List<listePresence> getPresenceByMonth(int mois);
    
    List<listePresence> getPresenceByWeek(int year, int months, int days);
    

    
}
