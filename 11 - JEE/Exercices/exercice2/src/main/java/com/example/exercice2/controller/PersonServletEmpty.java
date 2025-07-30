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

@WebServlet(name = "personServletEmpty", value = "/personempty")
public class PersonServletEmpty extends HttpServlet {

    private List<Person> persons;


    @Override
    public void init() throws ServletException {
        persons = new ArrayList<>();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("persons", persons);
        req.getRequestDispatcher("/WEB-INF/person/list.jsp").forward(req,resp);
    }
}
