package com.example.exhopital.interfaces;

import com.example.exhopital.model.Patient;

import java.util.List;

public interface IPatientService {

    public List<Patient> getAll();

    public void addPatient(Patient dog);

    public Patient getPatient(int id);
    List<Patient> searchByNomOrPrenom(String keyword);
}
