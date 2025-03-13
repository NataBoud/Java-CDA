package org.example.Exo6;

import org.example.Exo6.Animaux.Elephant;
import org.example.Exo6.Animaux.Lion;

import java.util.Scanner;

public class IHM {
    private static Enclot<Elephant> enclosDesElephants = new Enclot<>();
    private static Enclot<Lion> enclosDesLions = new Enclot<>();
    
    private static Scanner sc = new Scanner(System.in);

    public static void init() {
        Lion steve = new Lion("Steve", 10);
        Lion lana = new Lion("Lana", 11);
        Lion simba = new Lion("Simba", 3);
        Lion nala = new Lion("Nala", 2);

        Elephant elmer = new Elephant("Elmer", 15, 400);
        Elephant dumbo = new Elephant("Dumbo", 3, 120);
        Elephant hathi = new Elephant("Hathi", 45, 875);
        Elephant tantor = new Elephant("Tantor", 12, 384);


        enclosDesLions.ajouterAnimal(steve);
        enclosDesLions.ajouterAnimal(lana);
        enclosDesLions.ajouterAnimal(simba);
        enclosDesLions.ajouterAnimal(nala);

        enclosDesElephants.ajouterAnimal(elmer);
        enclosDesElephants.ajouterAnimal(dumbo);
        enclosDesElephants.ajouterAnimal(hathi);
        enclosDesElephants.ajouterAnimal(tantor);
        
    }

    public static void menuAjouterElephant() {
        System.out.print("-- Ajout d'un Elephant --\nnom: ");
        String nom = sc.nextLine();
        System.out.print("age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("poids: ");
        float poids = sc.nextFloat();
        sc.nextLine();
        enclosDesElephants.ajouterAnimal(new Elephant(nom, age, poids));
    }

    public static void menuAjouterLion() {
        System.out.print("-- Ajout d'un lion --\nnom: ");
        String nom = sc.nextLine();
        System.out.print("age: ");
        int age = sc.nextInt();
        sc.nextLine();
        enclosDesLions.ajouterAnimal(new Lion(nom, age));
    }

    public static void menuEnclosLions() {
        while (true) {
            System.out.print("""
                    -- Menu Enclos --
                    type: Lion
                    1-- Afficher
                    2-- Ajouter Lion
                    0-- Annuler
                    
                    >\s""");

            String choix = sc.nextLine();

            switch (choix) {
                case "1" -> enclosDesLions.afficherAnimaux();
                case "2" -> menuAjouterLion();
                case "0" -> {
                    return;
                }
                default -> System.out.println("Erreur de Saisie!");
            }
        }
    }

    public static void menuEnclosElephants() {
        while (true) {
            System.out.print("""
                    -- Menu Enclos --
                    type: Elephant
                    1-- Afficher
                    2-- Ajouter Elephant
                    0-- Annuler
                    
                    >\s""");

            String choix = sc.nextLine();

            switch (choix) {
                case "1" -> enclosDesElephants.afficherAnimaux();
                case "2" -> menuAjouterElephant();
                case "0" -> {
                    return;
                }
                default -> System.out.println("Erreur de Saisie!");
            }
        }
    }


    public static void main(String[] args) {
        init();

        while (true) {
            System.out.print("""
                    == Gestion du Zoo ==
                    1-- Menu enclot des elephants
                    2-- Menu encclot des lions
                    0-- Quitter
                    
                    >\s""");
            String choix = sc.nextLine();

            switch (choix) {
                case "1" -> menuEnclosElephants();
                case "2" -> menuEnclosLions();
                case "0" -> {return;}
                default -> System.out.println("Erreur de Saisie!");
            }
        }
    }

}
