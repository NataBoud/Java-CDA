package org.example;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // String prenom;
        // String nom;

        // System.out.println("Saisir un prénom : ");
        // prenom = scanner.nextLine();

        // System.out.println("Saisir un nom : ");
        // nom = scanner.nextLine();

        // System.out.println("Bonjour " + prenom + " " + nom.toUpperCase() + ".");

//        System.out.println("Enter votre age: ");
//        int value = scanner.nextInt();
//
//        if(value >= 18) {
//            System.out.println("Vous etes majeur");
//        }else
//            System.out.println("Vous êtes mineur");


//        switch (value) {
//            case 1, 2, 3, 4, 5:
//                System.out.println("Vous êtes mineur");
//                break;
//                case 6, 7, 8, 9, 10:
//                    System.out.println("Vous êtes mineur");
//        }


//        switch (value) {
//            case 1,2,3,4,5 -> System.out.println("Vous etes majeur");
//            case 6,7 -> System.out.println("Vous etes majeur .....");
//            default -> System.out.println("Vous etes majeur .....");
//        }
//
//        int[] tableau = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//
//        for (int i = 0; i < tableau.length; i++) {
////            System.out.println(tableau[i]);
//        }
//
//        for (int value : tableau) {
////            System.out.println("Ma valeur est : " + value);
//        }


//        int i = 0;
//        while (true) {
//            if (i > 15) {
//                break;
//            }
////            System.out.println(i);
//        }
//
//        do {
//            i++;
//            System.out.println(i);
//        } while (i < 15);

        // Exercice : Nombre mystère

        Random random = new Random();
        int nombreMystere = random.nextInt(100);

        Scanner scanner = new Scanner(System.in);

        int totalTentatives = 7;
        int tentativeRestante = totalTentatives;
        int nombreSaisi;

        System.out.println("Devinez le nombre entre 1 et 100");

        while (tentativeRestante > 0) {
            int tentativeActuelle = totalTentatives - tentativeRestante + 1;
            System.out.print("Tentative " + tentativeActuelle + " sur " + totalTentatives + " - Entrez un nombre : ");
            nombreSaisi = scanner.nextInt();
            tentativeRestante--;

            if (nombreSaisi > nombreMystere) {
                System.out.println("Le nombre est plus petit.");
            } else if (nombreSaisi < nombreMystere) {
                System.out.println("Le nombre est plus grand.");
            } else {
                System.out.println("Bravo ! Le nombre mystère est " + nombreMystere +
                        ". Vous avez trouvé en " + tentativeActuelle + " tentatives !");
                scanner.close();
                return;
            }

            if (tentativeRestante == 0) {
                System.out.println("Perdu, le nombre mystère était : " + nombreMystere);
            }
        }

    }
}