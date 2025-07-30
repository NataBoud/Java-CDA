package com.example.exercice3.controller;


import com.example.exercice3.model.Cat;
import com.example.exercice3.service.IServiceCat;
import com.example.exercice3.service.ServiceCatList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*

Version sans BDD
 */

@WebServlet("/cat")
public class CatServlet extends HttpServlet {

    private IServiceCat catService;


    @Override
    public void init() throws ServletException {
        catService = new ServiceCatList();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // afficher la page formulaire
        req.setAttribute("catList", catService.getAll());
        req.getRequestDispatcher("/WEB-INF/cat/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recuperer les infos du formulaire pour ajouter un chat
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String favMeal = req.getParameter("favMeal");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        // Creation d'un chat
        Cat cat = new Cat(name, breed, favMeal, dateOfBirth);
        // Ajout du chat a la liste
        catService.addCat(cat);
        resp.sendRedirect(getServletContext().getContextPath()+"/cat");
    }
}
