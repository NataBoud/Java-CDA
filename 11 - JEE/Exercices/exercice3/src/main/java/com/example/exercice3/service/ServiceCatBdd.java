package com.example.exercice3.service;

import com.example.exercice3.model.Cat;
import com.example.exercice3.repository.CatRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/*
Necessaire pour la
Version avec BDD en bonus
 */

public class ServiceCatBdd implements IServiceCat{

    private CatRepository catRepository;
    private SessionFactory _sessionFactory;
    private Session session;


    public ServiceCatBdd(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;
    }

    @Override
    public List<Cat> getAll() {
        List<Cat> cats = new ArrayList<>();
        session = _sessionFactory.openSession();
        catRepository = new CatRepository(session);
        try {
            cats = catRepository.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cats;
    }

    @Override
    public void addCat(Cat cat) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        catRepository =  new CatRepository(session);
        try {
            catRepository.create(cat);
            session.getTransaction().commit();
        }catch(Exception e){
            try {
                session.getTransaction().rollback();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }finally {
            session.close();
        }
    }
}
