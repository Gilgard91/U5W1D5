package com.epicode.GestionePrenotazioni;

import com.epicode.GestionePrenotazioni.entities.Edificio;
import com.epicode.GestionePrenotazioni.entities.Postazione;
import com.epicode.GestionePrenotazioni.entities.Prenotazione;
import com.epicode.GestionePrenotazioni.entities.Utente;
import com.epicode.GestionePrenotazioni.services.EdificiService;
import com.epicode.GestionePrenotazioni.services.PostazioniService;
import com.epicode.GestionePrenotazioni.services.PrenotazioniService;
import com.epicode.GestionePrenotazioni.services.UtentiService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UtentiService utentiService;
    @Autowired
    private EdificiService edificiService;
    @Autowired
    private PostazioniService postazioniService;
    @Autowired
    private PrenotazioniService prenotazioniService;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);

        Faker faker = new Faker(Locale.ITALY);

        try {
            Utente utente1 = new Utente(faker.name().username(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
            utentiService.save(utente1);

            Utente utente2 = new Utente(faker.name().username(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
            utentiService.save(utente2);

            Edificio edificioMilano = ctx.getBean("edificio_milano", Edificio.class);
            edificiService.save(edificioMilano);

            Postazione postazioneMilano = ctx.getBean("postazione_milano", Postazione.class);
            postazioniService.save(postazioneMilano);

            Prenotazione prenotazione1 = new Prenotazione(LocalDate.now(), postazioneMilano, utente1);
            Prenotazione prenotazione2 = new Prenotazione(LocalDate.now(), postazioneMilano, utente2);

            if(postazioniService.isPostazioneDisponibile(postazioneMilano, LocalDate.now())){
                prenotazioniService.save(prenotazione1);
                prenotazioniService.save(prenotazione2);
                System.out.println("Prenotazione effettuata");
            } else{
                System.out.println("Postazione non disponibile, prenotazione non effettuata");
            }



//            System.out.println("---------------------------------------------");
//            utentiService.getAllUsers().forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
