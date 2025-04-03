package org.example.ExoHibernate.Repository;

import org.example.ExoHibernate.Entity.Student;

import javax.persistence.EntityManager;

public class StudentRepository {
    private EntityManager entityManager;
    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }

    public void delete(Student student) {
        entityManager.remove(student);
    }
}
