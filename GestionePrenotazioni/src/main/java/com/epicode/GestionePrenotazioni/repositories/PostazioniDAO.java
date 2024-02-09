package com.epicode.GestionePrenotazioni.repositories;

import com.epicode.GestionePrenotazioni.entities.Postazione;
import com.epicode.GestionePrenotazioni.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioniDAO extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoAndCitta(TipoPostazione tipoPostazione, String citta);
}
