package com.example.exercice2.servlets;

import com.example.exercice2.models.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/liste-personnes")
public class ListePersonnesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Personne> personnes = Arrays.asList(
                new Personne("Dupont", "Jean", 30),
                new Personne("Martin", "Claire", 25),
                new Personne("Durand", "Luc", 40)
        );

        req.setAttribute("personnes", personnes);
        req.getRequestDispatcher("/WEB-INF/views/liste-personnes.jsp").forward(req, resp);
    }
}
