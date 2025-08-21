package org.example.demoapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Repository {
    private Session session;

    public Repository(Session session) {
        this.session = session;
    }

    public Person create (Person element){
        try{
            session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }

    }
    public Person update (Person element){
        try{
            session.beginTransaction();
            session.update(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }

    }

    public boolean delete (Person element){
        try{
            session.beginTransaction();
            session.delete(element);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }


    public List<Person> findAll() {
        List<Person> personList = null;

        Query<Person> produitQuery = session.createQuery("from Person ",Person.class);
        personList = produitQuery.list();
;
        return personList;
    }
}
