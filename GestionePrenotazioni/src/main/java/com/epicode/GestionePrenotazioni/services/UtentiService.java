package com.epicode.GestionePrenotazioni.services;

import com.epicode.GestionePrenotazioni.entities.Utente;
import com.epicode.GestionePrenotazioni.repositories.UtentiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtentiService {

    @Autowired
    UtentiDAO utentiDAO;

    public void save(Utente utente){
        utentiDAO.save(utente);
    }

    public List<Utente> getAllUsers(){
        return utentiDAO.findAllUsers();
    }
}
