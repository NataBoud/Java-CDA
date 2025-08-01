package com.example.exhopital.repository;

import com.example.exhopital.model.Patient;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient> {

    public PatientRepository(Session session) {
        super(session);
    }

    @Override
    public List<Patient> findAll() {
        return _session.createQuery("from Patient ").list();
    }

    @Override
    public Patient findById(int id) {
        return _session.get(Patient.class, id);
    }
}
