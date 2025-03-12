package org.example.Exo4;

import org.example.Exo4.Entity.Client;
import org.example.Exo4.Entity.Compte.CompteBancaire;
import org.example.Exo4.Entity.Compte.CompteCourant;
import org.example.Exo4.Entity.Compte.CompteEpargne;
import org.example.Exo4.Entity.Compte.ComptePayant;

import javax.swing.*;
import java.util.Scanner;

public class IHM {

    private Scanner scanner = new Scanner(System.in);

    private Client client = new Client("toto","tata","123456");

    public void start (){
        String entry;

        while (true){
            afficheMenu();
            entry = scanner.nextLine();
            switch (entry){
                case "1" -> listerLesCompte();
                case "2" -> ;
                case "3" -> ;
                case "4" -> ;
                case "5" -> ;
                default -> {
                    return;
                }

            }
        }

    }

    private void afficheMenu (){
        System.out.println("""
                1. lister les comptes bancaires
                2. creer un compte bancaire
                3. effectuer un depot
                4. effectuer un retrait
                5. afficher les operation et le solde
                0. quiter le programme                
                """);
    }

    private void listerLesCompte(){
        for(CompteBancaire compte : client.getListeCompte()){
            System.out.println(compte);
        }
    }

    private void creationCompte (){
        System.out.println("""
                1. creec compte courant
                2. cree compte epargne 
                3. cree compte payant
                """);
        String entry =scanner.nextLine();


    }

    private void creationcompte (String type){
        System.out.println("entrer le solde :");
        double solde = scanner.nextDouble();

        switch (type){
            case "1" ->{
                client.addCompte(new CompteCourant(solde,client));
            }
            case "2" ->{
                System.out.println("entrer le taux :");
                double taux = scanner.nextDouble();
                client.addCompte(new CompteEpargne(solde,client,taux));
            }
            case "3" ->{
                System.out.println("entrer le cout :");
                double cout = scanner.nextDouble();
                client.addCompte(new CompteEpargne(solde,client,cout));
            }
            default -> {
                return;
            }
        }
    }


    private void getcompte (){
        CompteBancaire[] compteBancaires= client.getListeCompte();
        for (CompteBancaire compteBancaire : compteBancaires){
//            switch (compteBancaire){
//                case CompteEpargne compteEpargne -> System.out.println(compteEpargne.getEpargneCalcul());
//                case CompteCourant compteCourant -> System.out.println();
//                case ComptePayant comptePayant -> System.out.println();
//                default -> System.out.println();
//            }

            if(compteBancaire instanceof CompteEpargne compteEpargne){
                compteEpargne.getEpargneCalcul();
            }
        }


    }


}
