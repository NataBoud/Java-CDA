package org.example.Exo4.Entity;

public class Operation {
    private int numero;
    private double montant;
    private Statut statut;

    private static int compteur = 1;

    public Operation( double montant, Statut statut) {
        this.numero = compteur ++;
        this.montant = montant;
        this.statut = statut;
    }

    public int getNumero() {
        return numero;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}


