package com.example.exhopital.controller;

import com.example.exhopital.interfaces.IPatientService;
import com.example.exhopital.model.Patient;
import com.example.exhopital.service.PatientService;
import com.example.exhopital.utils.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "patientServlet", value = "/patient/*")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class PatientController extends HttpServlet {

    private IPatientService patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);

        switch (action) {
            case "list":
                showAll(req, resp);
                break;
            case "addform":
                showForm(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "details":
                showDetails(req, resp);
                break;
            case "search":
                searchPatients(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non reconnue");
                break;
        }
    }


    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients", patientService.getAll());
        req.getRequestDispatcher("/WEB-INF/patient/list.jsp").forward(req, resp);
    }

    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient patientToAdd = new Patient("", "", LocalDate.now(), "");
        req.setAttribute("patient", patientToAdd);
        req.getRequestDispatcher("/WEB-INF/patient/patient-form.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des champs
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        LocalDate dateNaissance = LocalDate.parse(req.getParameter("dateNaissance"));

        // Gestion de l'image
        Part imagePart = req.getPart("image"); // Nom du champ dans le formulaire
        String fileName = imagePart.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("/images");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        if (fileName != null && !fileName.isEmpty()) {
            imagePart.write(uploadPath + File.separator + fileName);
        }

        // Création du patient
        Patient patient = new Patient(nom, prenom, dateNaissance, fileName);

        // Enregistrement
        patientService.addPatient(patient);

        // Redirection
        resp.sendRedirect("list");
    }

    protected void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Patient patient = patientService.getPatient(id);
        req.setAttribute("patient", patient);

        req.getRequestDispatcher("/WEB-INF/patient/details.jsp").forward(req, resp);
    }

    protected void searchPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        req.setAttribute("patients", patientService.searchByNomOrPrenom(keyword));
        req.getRequestDispatcher("/WEB-INF/patient/list.jsp").forward(req, resp);
    }


}
