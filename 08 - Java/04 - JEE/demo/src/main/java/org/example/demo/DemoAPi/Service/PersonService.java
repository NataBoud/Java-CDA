package org.example.demo.DemoAPi.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import org.example.demo.DemoAPi.entity.Person;
import org.example.demo.DemoAPi.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonService {

//    private final PersonRepository personRepository;
//
//    public PersonService() {
//        personRepository = new PersonRepository();
//    }

    public List<Person> getAll (){
        return new ArrayList<>();
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
