package com.epicode.GestionePrenotazioni.services;

import com.epicode.GestionePrenotazioni.entities.Postazione;
import com.epicode.GestionePrenotazioni.entities.Prenotazione;
import com.epicode.GestionePrenotazioni.entities.TipoPostazione;
import com.epicode.GestionePrenotazioni.repositories.PostazioniDAO;
import com.epicode.GestionePrenotazioni.repositories.PrenotazioniDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostazioniService {

    @Autowired
    PostazioniDAO postazioniDAO;
    @Autowired
    PrenotazioniDAO prenotazioniDAO;

    public void save(Postazione postazione){
        postazioniDAO.save(postazione);
    }

    public boolean isPostazioneDisponibile(Postazione postazione, LocalDate data){
        List<Prenotazione> prenotazioni = prenotazioniDAO.findByPostazioneAndData(postazione, data);
        if(prenotazioni.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public List<Postazione> findByTipoAndCitta(TipoPostazione tipoPostazione, String citta){
        return postazioniDAO.findByTipoAndCitta(tipoPostazione, citta);
    }
}
