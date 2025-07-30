package com.example.exercice4.service;

import com.example.exercice4.model.Dog;
import com.example.exercice4.repository.DogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ServiceDog implements IServiceDog {

    private DogRepository dogRepository;
   // private SessionFactory _sessionFactory;
   // private Session _session;

    public ServiceDog() {
     //  this._sessionFactory = _sessionFactory;
       dogRepository = new DogRepository();
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public void addDog(Dog dog) {
        dogRepository.create(dog);
    }
}
