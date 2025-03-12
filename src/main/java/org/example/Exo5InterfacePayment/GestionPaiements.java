package org.example.Exo5InterfacePayment;

import org.example.Exo5InterfacePayment.paiement.CarteDeCredit;
import org.example.Exo5InterfacePayment.paiement.PayPal;

import java.util.Scanner;

public class GestionPaiements {
    public static void main(String[] args) {

//        Paiement carte = new CarteDeCredit("456", "12/27", "Toto Tata", "1234-5678-9876-5432");
//        Paiement paypal = new PayPal("toto@tata.com", "123");

//        System.out.println(carte.effectuerPaiement(150.75));
//        System.out.println(paypal.effectuerPaiement(200.00));

        Scanner scanner = new Scanner(System.in);
        Paiement paiement = null;

        System.out.println("Choisissez le mode de paiement :");
        System.out.println("1. Carte de Crédit");
        System.out.println("2. PayPal");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                paiement = CarteDeCredit.renseignerCarte();
                break;
            case 2:
                paiement = PayPal.renseignerComptePayPal();
                break;
            default:
                System.out.println("Mode de paiement invalide !");
                return;
        }


        double montant = -1;


        System.out.println(paiement.effectuerPaiement(montant));


    }
}
