package DAO;

import entities.Evento;
import exeption.EventoNonTrovato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import javax.swing.text.html.parser.Entity;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEvent (Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("evento" + evento.getTitolo()+" salvato");
    }

    public Evento trovaEvento(long studentId) throws EventoNonTrovato {
        Evento evento = em.find(Evento.class, studentId);
        if(evento == null) throw new EventoNonTrovato(studentId);
        return evento ;
    }

    public void eleminaEvento(long eventoId) throws EventoNonTrovato {
        Evento evento = this.trovaEvento(eventoId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(evento);
        transaction.commit();
        System.out.println("Evento con id " + evento.getTitolo() + " eliminato correttamente!");
    }
}
