package com.example.demo_base;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/design")
public class MonServletJSP extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // getServletContext().getRequestDispatcher("/design.jsp").forward(req,resp);
        req.getRequestDispatcher("/design.jsp").forward(req,resp);
    }
}
