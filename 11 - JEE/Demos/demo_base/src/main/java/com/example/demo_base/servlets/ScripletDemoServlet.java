package com.example.demo_base.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/demo/scriplet")
public class ScripletDemoServlet extends HttpServlet {

    private String prenom;
    private String nom;
    private List<String> prenoms;


    @Override
    public void init() throws ServletException {
        System.out.println("Je passe dans la methode init");
        prenom = "toto";
        nom = "dupond";
        prenoms = new ArrayList<>();
        prenoms.add("Elodie");
        prenoms.add("Ihab");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = "Toto";
//        int age = 25;
        System.out.println("Je passe dans la methode doGet");
        req.setAttribute("lenom", nom);
        req.setAttribute("leprenom", prenom);
        req.setAttribute("prenoms", prenoms);
        req.getRequestDispatcher("/demo-scriplet.jsp").forward(req,resp);
    }
}
