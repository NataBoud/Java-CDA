package org.example.demo.DemoAPi.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.demo.DemoAPi.Service.PersonService;
import org.example.demo.DemoAPi.entity.Person;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("/person")
public class PersonController {

//    private final PersonService personService;
//    @Inject
//    public PersonController(PersonService personService) {
//        this.personService =personService;
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll (){
        return new ArrayList<>();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPerson (Person person){
        return null;
    }
}
