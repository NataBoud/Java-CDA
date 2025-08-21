//package org.example.demoapi;
//
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import java.util.List;
//
//@Path("/person")
//public class HelloResource {
//
//
//
//
//
//    public HelloResource() {
//
//    }
//
//    @GET
//    @Produces("application/json")
//    public List<Person> getall() {
//        return servicePerson.getAll();
//    }
//
//    @GET
//    @Path("json")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Person json(){
//        return new Person("tata",22);
//    }
//
//
//}