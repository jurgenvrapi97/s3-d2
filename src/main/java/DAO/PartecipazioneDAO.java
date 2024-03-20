package DAO;

import entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void savePartecipazione(Partecipazione partecipazione){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione salvata");
    }

    public Partecipazione trovaPartecipazione(long partecipazioneId){
        return em.find(Partecipazione.class, partecipazioneId);
    }

    public void eliminaPartecipazione(long partecipazioneId){
        Partecipazione partecipazione = this.trovaPartecipazione(partecipazioneId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione con id " + partecipazione.getId() + " eliminata correttamente!");
    }
}
