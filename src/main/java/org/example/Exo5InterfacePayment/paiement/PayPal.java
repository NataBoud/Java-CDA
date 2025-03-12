package org.example.Exo5InterfacePayment.paiement;

import org.example.Exo5InterfacePayment.Paiement;

import java.util.Scanner;

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

    // créer un compte PayPal via le terminal
    public static PayPal renseignerComptePayPal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        return new PayPal(email, motDePasse);
    }

}
