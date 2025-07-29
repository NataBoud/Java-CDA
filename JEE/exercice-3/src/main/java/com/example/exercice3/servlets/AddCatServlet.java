package com.example.exercice3.servlets;

import com.example.exercice3.models.Cat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add-cat")
public class AddCatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add-cat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String favoriteMeal = req.getParameter("favoriteMeal");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        Cat newCat = new Cat(name, breed, favoriteMeal, birthDate);

        // Simuler l'ajout en session
        HttpSession session = req.getSession();
        List<Cat> cats = (List<Cat>) session.getAttribute("cats");

        if (cats == null) {
            cats = new ArrayList<>();
        }

        cats.add(newCat);
        session.setAttribute("cats", cats);

        resp.sendRedirect(req.getContextPath() + "/cats");
    }
}
