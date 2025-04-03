package org.example.ExoHibernate.Repository;

import org.example.ExoHibernate.Entity.Exam;

import javax.persistence.EntityManager;

public class ExamRepository {
    private EntityManager entityManager;
    public ExamRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Exam exam) {
        entityManager.persist(exam);
    }

    public Exam findById(int id) {
        return entityManager.find(Exam.class, id);
    }

    public void update(Exam exam) {
        entityManager.merge(exam);
    }

    public void delete(Exam exam) {
        entityManager.remove(exam);
    }
}
