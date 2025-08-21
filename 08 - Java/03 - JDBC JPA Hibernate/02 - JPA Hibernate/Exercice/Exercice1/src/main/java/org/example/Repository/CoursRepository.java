package org.example.Repository;

import org.example.entity.Cours;

import javax.persistence.EntityManager;

public class CoursRepository extends BaseRepository<Cours>{

    public CoursRepository(EntityManager em) {
        super(em);
    }
}
