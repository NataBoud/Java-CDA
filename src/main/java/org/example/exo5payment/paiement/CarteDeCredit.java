package org.example.exo5payment.paiement;

import org.example.exo5payment.Paiement;

import java.util.Scanner;

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
        if (montant > 0) {
            return "Paiement de " + montant + "€ effectué avec succès par Carte de Crédit (" + numeroCarte + ").";

        }
        return "Erreur : Le montant doit être positif.";
    }

    // créer une carte via le terminal
    public static CarteDeCredit renseignerCarte() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Numéro de carte : ");
        String numero = scanner.nextLine();
        System.out.print("Titulaire : ");
        String titulaire = scanner.nextLine();
        System.out.print("Date d'expiration (MM/YY) : ");
        String expiration = scanner.nextLine();
        System.out.print("CVV : ");
        String cvv = scanner.nextLine();
        return new CarteDeCredit(numero, titulaire, expiration, cvv);
    }
}
