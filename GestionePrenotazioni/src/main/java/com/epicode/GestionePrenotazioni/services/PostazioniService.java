package com.epicode.GestionePrenotazioni.services;

import com.epicode.GestionePrenotazioni.entities.Postazione;
import com.epicode.GestionePrenotazioni.repositories.PostazioniDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class PostazioniService {

    @Autowired
    PostazioniDAO postazioniDAO;

    public void save(Postazione postazione){
        postazioniDAO.save(postazione);
    }
}
