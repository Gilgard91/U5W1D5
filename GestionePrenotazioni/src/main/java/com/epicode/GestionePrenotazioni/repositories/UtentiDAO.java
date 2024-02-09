package com.epicode.GestionePrenotazioni.repositories;

import com.epicode.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtentiDAO extends JpaRepository<Utente, Long> {
    @Query("SELECT u FROM Utente u")
    List<Utente> findAllUsers();
}
