package DAO;

import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void saveLocation(Location location){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location " + location.getNome() + " salvata");
    }

    public Location trovaLocation(long locationId){
        return em.find(Location.class, locationId);
    }

    public void eliminaLocation(long locationId){
        Location location = this.trovaLocation(locationId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(location);
        transaction.commit();
        System.out.println("Location con id " + location.getId() + " eliminata correttamente!");
    }
}
