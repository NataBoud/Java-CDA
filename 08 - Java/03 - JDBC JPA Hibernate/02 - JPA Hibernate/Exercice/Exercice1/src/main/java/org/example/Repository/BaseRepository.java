package org.example.Repository;

import org.example.exception.NotFoundException;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepository<T> {

    protected EntityManager em;

    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public T save(T element){
        try{
            em.getTransaction().begin();
            em.persist(element);
            em.getTransaction().commit();
            return element;
        }catch (Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return null;
        }
    }

    public boolean delete (T element){
        try{
            em.getTransaction().begin();
            em.remove(element);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return false;
        }
    }

    public T findById(Class<T> classe, int id){
        T element = em.find(classe,id);
        if(element != null){
            return element;
        }else{
            throw new NotFoundException("Element not found");
        }
    }

    public List<T> findall (Class<T> classe){
        String querystr = "FROM"+classe.getSimpleName();
        return em.createQuery(querystr,classe).getResultList();
    }
}
