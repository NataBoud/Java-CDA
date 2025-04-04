package org.example.ExoJpaHibernate.Repository;

import org.example.ExoJpaHibernate.Entity.Course;

import javax.persistence.EntityManager;

public class CourseRepository {
    private EntityManager entityManager;
    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Course course) {
        entityManager.persist(course);
    }

    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    public void update(Course course) {
        entityManager.merge(course);
    }

    public void delete(Course course) {
        entityManager.remove(course);
    }
}
