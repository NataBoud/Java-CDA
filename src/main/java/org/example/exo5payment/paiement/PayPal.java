package org.example.exo5payment.paiement;

import org.example.exo5payment.Paiement;

public class PayPal implements Paiement {
    private String email;
    private String motDePasse;

    public PayPal(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    @Override
    public String effectuerPaiement(double montant) {
        return "Paiement de " + montant + "€ effectué avec succès via PayPal (" + email + ").";
    }
}
