package com.example.exercice3.repository;

import com.example.exercice3.model.Cat;
import org.hibernate.Session;

import java.util.List;

/*
Necessaire pour la
Version avec BDD en bonus
 */

public class CatRepository extends Repository<Cat>{


    public CatRepository(Session session) {
        super(session);
    }

    @Override
    public List<Cat> findAll() {
        return _session.createQuery("from Cat").list();
    }
}
