package org.example.Exo5InterfacePayment.paiement;

import org.example.Exo5InterfacePayment.Paiement;

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
        while (montant <= 0) {
            System.out.print("Entrez le montant du paiement : ");
            Scanner scanner = new Scanner(System.in);
            montant = scanner.nextDouble();
            if (montant <= 0) {
                System.out.println("Erreur : Le montant doit être positif.");
            }
        }
        return "Paiement de " + montant + "€ effectué avec succès via carte de credit " + numeroCarte + ".";
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
