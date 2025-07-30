package com.example.demo_parameters;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Afficher la page Formulaire
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperation des donnees du formulaire
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        Double age = Double.parseDouble(req.getParameter("age"));
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("age: " + age);
     //   req.getRequestDispatcher("/form.jsp").forward(req, resp);
      //  doGet(req, resp);

        resp.sendRedirect(getServletContext().getContextPath());
    }
}
