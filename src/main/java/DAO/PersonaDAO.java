package DAO;

import entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void savePersona(Persona persona){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Persona " + persona.getNome() + " salvata");
    }

    public Persona trovaPersona(long personaId){
        return em.find(Persona.class, personaId);
    }

    public void eliminaPersona(long personaId){
        Persona persona = this.trovaPersona(personaId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(persona);
        transaction.commit();
        System.out.println("Persona con id " + persona.getId() + " eliminata correttamente!");
    }
}
