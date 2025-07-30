package com.example.exercice4.repository;


import com.example.exercice4.model.Dog;

import java.util.List;

public class DogRepository extends BaseRepository<Dog> {


    @Override
    public Dog findById(int id) {
        session = sessionFactory.openSession();
        Dog dog = session.get(Dog.class, id);
        session.close();
        return dog;
    }

    @Override
    public List<Dog> findAll() {
        session = sessionFactory.openSession();
        List<Dog> dogs = session.createQuery("from Dog", Dog.class).list();
        session.close();
        return dogs;
    }
}
