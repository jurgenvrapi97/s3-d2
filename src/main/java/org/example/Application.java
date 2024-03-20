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

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D1");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO evento = new EventoDAO(em);
        PersonaDAO persona = new PersonaDAO(em);
        LocationDAO location = new LocationDAO(em);
        PartecipazioneDAO partecipazione = new PartecipazioneDAO(em);

        Location location1 = new Location("giardino fiorito", "tokyo");
        Evento uno = new Evento("Festival dei fiori", "2024-06-12", "musica e fiori", TipoEvento.PUBBLICO, 10000, location1);
        Persona nuova = new Persona("marco","rossi","marcorossi@gmail.com", 1998, Sesso.M);
        Partecipazione partecipazione1 = new Partecipazione(nuova,uno,Stato.CONFERMATA);

        location.saveLocation(location1);
        evento.saveEvent(uno);
        persona.savePersona(nuova);
        partecipazione.savePartecipazione(partecipazione1);

    }
}
