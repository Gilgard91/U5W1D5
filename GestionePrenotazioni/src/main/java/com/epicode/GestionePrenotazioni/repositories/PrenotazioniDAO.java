package com.epicode.GestionePrenotazioni.repositories;

import com.epicode.GestionePrenotazioni.entities.Postazione;
import com.epicode.GestionePrenotazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioniDAO extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
}
