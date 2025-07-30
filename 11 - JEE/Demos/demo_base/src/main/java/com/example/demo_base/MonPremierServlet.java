package com.example.demo_base;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "monPremierServlet", value = "/monservlet")
public class MonPremierServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Une requete GET a ete envoye a /monservlet");

        // un commentaire sur une lin

        // Renvoyer du texte brute
        // Definir le type de retour
//            resp.setContentType("text/plain");
//            PrintWriter out = resp.getWriter();
//            out.println("<h1>MonPremierServlet</h1>");
            // Fin renvoie texte brut

        // Renvoyer du HTML

//        resp.setContentType("text/html");
//
//        PrintWriter out = resp.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html><body>");
//        out.println("<h1>MonPremierServlet</h1>");
//        out.println("</body></html>");

        // forwarding vers une JSP
        getServletContext().getRequestDispatcher("/monjsp.jsp").forward(req,resp);


    }
}
