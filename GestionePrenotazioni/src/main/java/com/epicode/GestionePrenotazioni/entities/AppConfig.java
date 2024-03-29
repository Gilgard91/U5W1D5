package com.epicode.GestionePrenotazioni.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {



    @Bean(name = "edificio_milano")
    public Edificio edificioMilano(){
        return new Edificio("Google", "Via Federico Confalonieri 4", "Milano");
    }

    @Bean(name = "edificio_roma")
    public Edificio edificioRoma(){
        return new Edificio("Facebook", "Corso Magenta 85", "Roma");
    }

    @Bean(name = "edificio_torino")
    public Edificio edificioTorino(){
        return new Edificio("Tik Tok", "Via Cernaia 18", "Torino");
    }

    @Bean(name = "postazione_milano")
    public Postazione postazioneMilano(){
        return new Postazione(420, "Sala riunioni della sede Google di Milano", TipoPostazione.SALA_RIUNIONI, 20, edificioMilano());
    }

    @Bean(name = "postazione_roma")
    public Postazione postazioneRoma(){
        return new Postazione(747, "Openspace della sede Facebook di Roma", TipoPostazione.OPENSPACE, 50, edificioRoma());
    }

    @Bean(name = "postazione_torino")
    public Postazione postazioneTorino(){
        return new Postazione(123, "Ufficio privato della sede Tik Tok di Torino", TipoPostazione.PRIVATO, 5, edificioTorino());
    }


}
