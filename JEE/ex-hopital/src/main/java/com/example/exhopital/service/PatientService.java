package com.example.exhopital.service;

import com.example.exhopital.interfaces.IPatientService;
import com.example.exhopital.model.Patient;
import com.example.exhopital.repository.PatientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PatientService implements IPatientService {

    private Session session;
    private SessionFactory _sessionFactory;
    private PatientRepository patientRepository;


    public PatientService(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        session = _sessionFactory.openSession();
        patientRepository = new PatientRepository(session);
        try {
            patients = patientRepository.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return patients;
    }

    @Override
    public void addPatient(Patient patient) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        patientRepository =  new PatientRepository(session);
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
        }catch(Exception e){
            try {
                session.getTransaction().rollback();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public Patient getPatient(int id) {
        Patient patient = null;
        session = _sessionFactory.openSession();
        patientRepository = new PatientRepository(session);
        try {
            patient = patientRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return patient;
    }

    public List<Patient> searchByNomOrPrenom(String keyword) {
        try (Session session = _sessionFactory.openSession()) {
            return session.createQuery("from Patient where lower(nom) like :kw or lower(prenom) like :kw", Patient.class)
                    .setParameter("kw", "%" + keyword.toLowerCase() + "%")
                    .list();
        }
    }
}
