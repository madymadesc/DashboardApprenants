/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.demo.repositories;

import com.dashboard.demo.model.listePresence;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author awa.keita
 */
@Repository
public interface PresenceRepository extends JpaRepository <listePresence, Integer> {
    
    List<listePresence> getPresenceByDate(LocalDate localDate);
    List<listePresence> getPresenceByDateIs(LocalDate dates);
    //List<listePresence> getPresenceListByDateMonthAndIntervale(LocalDate min, LocalDate max);
    }
