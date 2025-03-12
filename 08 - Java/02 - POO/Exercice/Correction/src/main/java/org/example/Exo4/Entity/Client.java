package org.example.Exo4.Entity;

import org.example.Exo4.Entity.Compte.CompteBancaire;

public class Client {
    private String nom;
    private String prenom;
    private String id;
    private CompteBancaire[] listeCompte;

    public Client(String nom, String prenom, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.listeCompte = new CompteBancaire[10];
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CompteBancaire[] getListeCompte() {
        return listeCompte;
    }

    public void addCompte(CompteBancaire compteBancaire){
        for(int i = 0 ; i< listeCompte.length ; i++){
            if(listeCompte[i] == null){
                listeCompte[i] = compteBancaire;
                break;
            }
        }
    }
}
