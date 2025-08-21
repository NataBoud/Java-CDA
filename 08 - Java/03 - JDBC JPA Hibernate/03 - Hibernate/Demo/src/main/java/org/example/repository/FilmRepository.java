package org.example.repository;

import org.example.entity.Film;
import org.example.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FilmRepository {
    private Session session;
    private SessionFactory sessionFactory ;

    public FilmRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public Film createOrUpdate (Film film){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(film);
            session.getTransaction().commit();
            return film;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete (int id){
        try{
            Film film = findById(id);
            if(film != null){
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.delete(film);
                session.getTransaction().commit();
                return true;
            }
            return false;

        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public Film findById (int id){
        try{
            session= sessionFactory.openSession();
            Film film = session.get(Film.class,id);
            return film;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }finally {
            session.close();
        }



    }

    public List<Film> getAll (){
        try{
            session = sessionFactory.openSession();
            List<Film> films = session.createQuery("FROM Film",Film.class).list();
            return films;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }finally {
            session.close();
        }

    }
}
