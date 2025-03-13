package org.example.Exo7ListExeptionBilleterie;

import org.example.Exo7ListExeptionBilleterie.evenement.Adresse;
import org.example.Exo7ListExeptionBilleterie.evenement.Billet;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private Adresse adresse;
    private String telephone;
    private int age;

    // Liste des billets réservés par le client
    private List<Billet> billets = new ArrayList<>();

    public Client(String nom, String prenom, Adresse adresse, String telephone, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Ajouter un billet à la liste des billets du client
    public void ajouterBillet(Billet billet) {
        this.billets.add(billet);
    }

    // Récupérer les billets réservés par ce client
    public List<Billet> getBillets() {
        return billets;
    }
}
