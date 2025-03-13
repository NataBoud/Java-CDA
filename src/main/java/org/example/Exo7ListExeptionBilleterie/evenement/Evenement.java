package org.example.Exo7ListExeptionBilleterie.evenement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evenement {
    private String nom;
    private Lieu lieu;
    private LocalDate date;
    private String heure;
    private int nbPlaces;
    private List<Billet> billets = new ArrayList<>();

    public Evenement(String nom, Lieu lieu, LocalDate date, String heure, int nbPlaces, List<Billet> billets) {
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.heure = heure;
        this.nbPlaces = nbPlaces;
        this.billets = billets;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }
}
