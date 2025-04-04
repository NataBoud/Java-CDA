package org.example.ExoHibernate.repository;

import org.example.ExoHibernate.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public abstract class BaseRepository<T> {
    protected final SessionFactory sessionFactory;
    private final Class<T> entityType;

    public BaseRepository(Class<T> entityType) {
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
        this.entityType = entityType;
    }

    public T save(T element) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(element);
            transaction.commit();
            return element;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(T element) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(element);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public T findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entityType, id);
        }
    }

    public List<T> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM " + entityType.getSimpleName(), entityType).getResultList();
        }
    }
}
