package org.example.Exo6GeneriqueZoo;

import org.example.Exo6GeneriqueZoo.animaux.Elephant;
import org.example.Exo6GeneriqueZoo.animaux.Lion;

import java.util.Scanner;

public class Zoo {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Enclos<Lion> enclosLion = new Enclos<>(5);  // Taille de 5 lions max
    private static final Enclos<Elephant> enclosElephant = new Enclos<>(3);  // Taille de 3 éléphants max

    public static void main(String[] args) {
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n--- Système de Gestion du Zoo ---");
            System.out.println("1. Créer un animal");
            System.out.println("2. Ajouter un animal à un enclos");
            System.out.println("3. Visualiser les animaux dans un enclos");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();  // retour à la ligne

            switch (choix) {
                case 1:
                    creerAnimal();
                    break;
                case 2:
                    ajouterAnimalEnclos();
                    break;
                case 3:
                    visualiserAnimaux();
                    break;
                case 4:
                    continuer = false;
                    System.out.println("Fermeture de l'application...");
                    break;
                default:
                    System.out.println("Option invalide !");
            }
        }
    }

    private static void creerAnimal() {
        System.out.println("Quel animal créer ? (1: Lion, 2: Elephant)");
        int choix = scanner.nextInt();
        scanner.nextLine(); // la ligne

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Âge : ");
        int age = scanner.nextInt();

        if (choix == 1) {
            enclosLion.ajouterAnimal(new Lion(nom, age));
        } else if (choix == 2) {
            System.out.print("Poids : ");
            float poids = scanner.nextFloat();
            enclosElephant.ajouterAnimal(new Elephant(nom, age, poids));
        } else {
            System.out.println("Choix invalide !");
        }
    }

    private static void ajouterAnimalEnclos() {
        System.out.println("Ajouter un animal à quel enclos ? (1: Lions, 2: Éléphants)");
        int choix = scanner.nextInt();

        if (choix == 1) {
            System.out.print("Nom du lion : ");
            String nom = scanner.next();
            enclosLion.ajouterAnimal(new Lion(nom, 5));
        } else if (choix == 2) {
            System.out.print("Nom de l'éléphant : ");
            String nom = scanner.next();
            enclosElephant.ajouterAnimal(new Elephant(nom, 5, 100.0f));
        } else {
            System.out.println("Choix invalide !");
        }
    }

    private static void visualiserAnimaux() {
        System.out.println("Voir les animaux dans quel enclos ? (1: Lions, 2: Éléphants)");
        int choix = scanner.nextInt();

        if (choix == 1) {
            System.out.println(enclosLion.afficherAnimaux());
        } else if (choix == 2) {
            System.out.println(enclosElephant.afficherAnimaux());
        } else {
            System.out.println("Choix invalide !");
        }
    }
}
