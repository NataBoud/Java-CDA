package org.example.ExoHibernate.Repository;

import org.example.ExoHibernate.Entity.Adresse;

import javax.persistence.EntityManager;

public class AdresseRepository {
    private EntityManager entityManager;

    public AdresseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Adresse adresse) {
        entityManager.persist(adresse);
    }

    public Adresse findById(int id) {
        return entityManager.find(Adresse.class, id);
    }

    public void update(Adresse adresse) {
        entityManager.merge(adresse);
    }

    public void delete(Adresse adresse) {
        entityManager.remove(adresse);
    }

}
