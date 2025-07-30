package com.example.demo_base.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo/jstl")
public class JstlDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> prenoms = new ArrayList<>();
        prenoms.add("Elodie");
        prenoms.add("Ihab");
        prenoms.add("Toto");
        req.setAttribute("prenoms",prenoms);
        req.setAttribute("isTrue",true);
        req.setAttribute("isFalse",false);
        req.setAttribute("nameDemo","ma super Demo !!!!!!");
        req.getRequestDispatcher("/demo-jstl.jsp").forward(req,resp);
    }
}
