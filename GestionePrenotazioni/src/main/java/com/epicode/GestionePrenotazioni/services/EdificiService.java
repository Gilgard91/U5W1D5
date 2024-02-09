package com.epicode.GestionePrenotazioni.services;

import com.epicode.GestionePrenotazioni.entities.Edificio;
import com.epicode.GestionePrenotazioni.repositories.EdificiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificiService {

    @Autowired
    EdificiDAO edificiDAO;

    public void save(Edificio edificio){
        edificiDAO.save(edificio);
    }

    public List<Edificio> getAllBuildings(){
        return edificiDAO.findAllBuildings();
    }
}
