/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.services;

import com.dashboard.demo.model.listePresence;
import com.dashboard.demo.repositories.PresenceRepository;
import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author awa.keita
 */
@Service
public class PresenceServiceImp implements PresenceService{
    @Autowired
    PresenceRepository presenceRepository;

    @Override
    public listePresence ajouterListe(listePresence presence) {
      return presenceRepository.save(presence);
    }

    @Override
    public void supprimerListe(listePresence presence) {
         presenceRepository.delete(presence);
    }

    @Override
    public List<listePresence> getAllPresence() {
        return presenceRepository.findAll();
    }

    @Override
    public List<listePresence> getAllPresenceByDate(LocalDate jour) {
      return presenceRepository.getPresenceByDate(jour);
    }

    @Override
    public List<listePresence> getPresenceByDates(LocalDate days) {
    return  presenceRepository.getPresenceByDateIs(days);
    }
    
    @Override
    public List<listePresence> getPresenceListIntervale(LocalDate min, LocalDate max) {
    return presenceRepository.getPresenceListByDateMonthAndIntervale(min, max);
    
 }
    

    @Override
    public List<listePresence> getPresenceByMonth(int mois) {
      LocalDate date = LocalDate.now().of(LocalDate.now().getYear(),mois, 1);
      LocalDate debut = date.withDayOfMonth(1);
      LocalDate fin = date.withDayOfMonth(date.lengthOfMonth());
      return presenceRepository.getPresenceListByDateMonthAndIntervale(debut, fin);
    
    }

    @Override
    public List<listePresence> getPresenceByWeek(int year, int months, int days) {
     LocalDate weeks = LocalDate.now().of(year, months,days);
     LocalDate premier = weeks.with(previousOrSame(DayOfWeek.MONDAY));
     LocalDate fin = weeks.with(nextOrSame(DayOfWeek.FRIDAY));
     return presenceRepository.getPresenceListByDateMonthAndIntervale(premier, fin);
       
    }


 
    
}
