package com.epicode.GestionePrenotazioni;

import com.epicode.GestionePrenotazioni.entities.Utente;
import com.epicode.GestionePrenotazioni.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UtentiService utentiService;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);

        try {
            Utente utente1 = ctx.getBean("utente", Utente.class);
            utentiService.save(utente1);
            System.out.println("---------------------------------------------");
            utentiService.getAllUsers().forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
