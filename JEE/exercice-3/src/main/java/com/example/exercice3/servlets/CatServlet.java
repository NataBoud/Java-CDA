package com.example.exercice3.servlets;

import com.example.exercice3.models.Cat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/cats")
public class CatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<Cat> cats = (List<Cat>) session.getAttribute("cats");

        if (cats == null) {
            cats = Arrays.asList(
                    new Cat("Minette", "Siamois", "Saumon", LocalDate.of(2020, 5, 12)),
                    new Cat("Grisou", "Maine Coon", "Poulet", LocalDate.of(2019, 8, 3)),
                    new Cat("Luna", "Persan", "Thon", LocalDate.of(2021, 2, 25))
            );
            session.setAttribute("cats", new ArrayList<>(cats));
        }

        req.setAttribute("cats", session.getAttribute("cats"));
        req.getRequestDispatcher("/WEB-INF/views/cats.jsp").forward(req, resp);
    }
}
