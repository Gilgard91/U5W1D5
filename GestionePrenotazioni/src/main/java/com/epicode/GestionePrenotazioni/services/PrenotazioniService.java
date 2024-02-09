package com.epicode.GestionePrenotazioni.services;

import com.epicode.GestionePrenotazioni.entities.Prenotazione;
import com.epicode.GestionePrenotazioni.entities.Utente;
import com.epicode.GestionePrenotazioni.repositories.PrenotazioniDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioniService {

    @Autowired
    PrenotazioniDAO prenotazioniDAO;

    public void save(Prenotazione prenotazione){
        prenotazioniDAO.save(prenotazione);
    }

    public boolean prenotazioneUtenteInData(Utente utente, LocalDate data){
        List<Prenotazione> prenotazioni = prenotazioniDAO.findByUtenteAndData(utente, data);
        return !prenotazioni.isEmpty();
    }
}
