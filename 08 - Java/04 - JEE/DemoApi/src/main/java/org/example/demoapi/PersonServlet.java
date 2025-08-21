package org.example.demoapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.runtime.ObjectMethods;

@WebServlet(name = "personServlet", value = "/person")
public class PersonServlet extends HttpServlet {
    ServicePerson servicePerson;

    public void init (){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        servicePerson = new ServicePerson(sessionFactory.openSession());
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON);

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.println(om.writeValueAsString(servicePerson.getAll()));
    }
}
