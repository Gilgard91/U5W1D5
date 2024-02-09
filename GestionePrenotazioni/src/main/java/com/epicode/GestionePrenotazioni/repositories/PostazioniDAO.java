package com.epicode.GestionePrenotazioni.repositories;

import com.epicode.GestionePrenotazioni.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostazioniDAO extends JpaRepository<Postazione, Long> {
}
