package org.example.exo5payment;

import org.example.exo5payment.paiement.CarteDeCredit;
import org.example.exo5payment.paiement.PayPal;

public class GestionPaiements {
    public static void main(String[] args) {
        Paiement carte = new CarteDeCredit("1234-5678-9876-5432", "Toto Tata", "12/26", "123");
        Paiement paypal = new PayPal("toto@toto.com", "motDePasse");

        System.out.println(carte.effectuerPaiement(150.75));
        System.out.println(paypal.effectuerPaiement(200.00));
    }
}
