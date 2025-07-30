package com.example.demo_base.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/demo/el")
public class ELDemoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode","el");
        req.setAttribute("nom","Bob (via EL)");
        req.getRequestDispatcher("/demo-el.jsp").forward(req,resp);
    }
}
