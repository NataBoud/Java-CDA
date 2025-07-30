package com.example.exercice2.controller;


import com.example.exercice2.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personServlet", value = "/person")
public class PersonServlet extends HttpServlet {

    private List<Person> persons;


    @Override
    public void init() throws ServletException {
        persons = new ArrayList<>();
        persons.add(new Person("toto","tata",25));
        persons.add(new Person("tutu","titi",25));
        persons.add(new Person("bob","bricoleur",25));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("persons", persons);
        req.getRequestDispatcher("/WEB-INF/person/list.jsp").forward(req,resp);
    }
}
