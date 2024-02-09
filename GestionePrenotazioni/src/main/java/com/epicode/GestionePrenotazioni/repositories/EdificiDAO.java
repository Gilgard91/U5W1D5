package com.epicode.GestionePrenotazioni.repositories;

import com.epicode.GestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificiDAO extends JpaRepository<Edificio, Long> {
    @Query("SELECT e FROM Edificio e")
    List<Edificio> findAllBuildings();
}
