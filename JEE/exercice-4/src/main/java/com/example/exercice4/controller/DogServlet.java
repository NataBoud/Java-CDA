package com.example.exercice4.controller;

import com.example.exercice4.model.Dog;
import com.example.exercice4.service.IServiceDog;
import com.example.exercice4.service.ServiceDog;
import com.example.exercice4.utils.SessionFactorySingleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "dogs", value = {"/dogs/*"})
public class DogServlet extends HttpServlet {

    private IServiceDog dogService;

    @Override
    public void init() throws ServletException {
       // dogService = new ServiceDog(SessionFactorySingleton.getSessionFactory());
        dogService = new ServiceDog();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo(); // ex: /add ou null

        if (pathInfo == null || pathInfo.equals("/")) {
            req.setAttribute("dogList", dogService.getAllDogs());
            req.getRequestDispatcher("/WEB-INF/dog/dogs.jsp").forward(req, resp);
        } else if (pathInfo.equals("/add")) {
            req.getRequestDispatcher("/WEB-INF/dog/add.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));

        Dog dog = Dog.builder()
                .name(name)
                .breed(breed)
                .dateOfBirth(dateOfBirth)
                .build();

        dogService.addDog(dog);
        resp.sendRedirect(req.getContextPath() + "/dogs");
    }

}
