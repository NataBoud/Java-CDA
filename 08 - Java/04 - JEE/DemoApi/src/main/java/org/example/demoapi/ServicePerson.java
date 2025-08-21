package org.example.demoapi;

import org.hibernate.Session;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServicePerson {

    private Repository repository;

    public ServicePerson(Session session) {
        repository = new Repository(session);
    }

    public List<Person> getAll (){
        return repository.findAll();
    }

    public Person addperson (Person person){
//        if(person != null){
//            personRepository.create(person);
//            return person;
//        }else{
//            return null ;
//        }
        return null;
    }
}
