package org.example;

import DAO.EventoDAO;
import entities.Evento;
import entities.TipoEvento;
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
        EventoDAO ed = new EventoDAO(em);

//        Evento uno = new Evento("Festival dei fiori", "2024-06-12", "musica e fiori", TipoEvento.PUBBLICO, 10000);
//        Evento due = new Evento("ACDC party", "2024-07-18", "reunion", TipoEvento.PRIVATO, 5000);
//        Evento tre = new Evento("Pop event", "2024-08-23", "musica e balli", TipoEvento.PUBBLICO, 20000);
//        Evento quattro = new Evento("Beach party", "2024-08-14", "party in riva al mare", TipoEvento.PUBBLICO, 50000);
//
//        ed.saveEvent(uno);
//        ed.saveEvent(due);
//        ed.saveEvent(tre);
//        ed.saveEvent(quattro);
        try {
            Evento uno = ed.trovaEvento(2);
            System.out.println(uno);
        } catch (EventoNonTrovato ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Evento uno = ed.trovaEvento(20);
            System.out.println(uno);
        } catch (EventoNonTrovato ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ed.eleminaEvento(4);
        } catch (EventoNonTrovato ex) {
            System.out.println(ex.getMessage());
        }


    }
}
