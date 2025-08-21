package org.example.demo.DemoAPi.repository;

import org.example.demo.DemoAPi.entity.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class PersonRepository {
    
    private SessionFactory sessionFactory;
    private Session session;

    public PersonRepository() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Person create (Person element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }
    public Person update (Person element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    public boolean delete (Person element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(element);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
    }


    public List<Person> findAll() {
        List<Person> personList = null;
        session = sessionFactory.openSession();
        Query<Person> produitQuery = session.createQuery("from Person ",Person.class);
        personList = produitQuery.list();
        session.close();
        return personList;
    }
}
