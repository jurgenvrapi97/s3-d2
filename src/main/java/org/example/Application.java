package org.example;

import DAO.EventoDAO;
import DAO.LocationDAO;
import DAO.PartecipazioneDAO;
import DAO.PersonaDAO;
import entities.*;
import exeption.EventoNonTrovato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D1");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO evento = new EventoDAO(em);
        LocationDAO loc = new LocationDAO(em);

        Location location = new Location("san siro", "milano");
        loc.saveLocation(location);

//        Concerto concerto1 = new Concerto("ACDC", "2024-05-01", "La meglio musica rock", TipoEvento.CONCERTO, 2000, location, true);
//        concerto1.setGenere(Genere.ROCK);
//        concerto1.setInStreaming(true);
//        evento.saveEvent(concerto1);
//        Concerto concerto2 = new Concerto("Renato Zero", "2024-05-06", "il miglio cantautore", TipoEvento.CONCERTO, 100000, location, true);
//        concerto2.setGenere(Genere.CLASSICO);
//        concerto2.setInStreaming(false);
//        evento.saveEvent(concerto2);


        evento.getConcertiPerGenere(Genere.ROCK);

        List<Concerto> concertiInStreaming = evento.getConcertiInStreaming(true);
        System.out.println("Concerti in streaming:");
        concertiInStreaming.forEach(System.out::println);

        List<Concerto> concertiPerGenere = evento.getConcertiPerGenere(Genere.CLASSICO);
        System.out.println("Concerti in streaming:");
        concertiPerGenere.forEach(System.out::println);


        em.close();
        emf.close();

    }
}
