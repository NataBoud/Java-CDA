package org.example.exo5payment.paiement;

import org.example.exo5payment.Paiement;

public class CarteDeCredit implements Paiement {
    private String numeroCarte;
    private String titulaire;
    private String dateExpiration;
    private String cvv;

    public CarteDeCredit(String cvv, String dateExpiration, String titulaire, String numeroCarte) {
        this.cvv = cvv;
        this.dateExpiration = dateExpiration;
        this.titulaire = titulaire;
        this.numeroCarte = numeroCarte;
    }

    @Override
    public String effectuerPaiement(double montant) {
        return "Paiement de " + montant + "€ effectué avec succès par Carte de Crédit (" + numeroCarte + ").";
    }
}
