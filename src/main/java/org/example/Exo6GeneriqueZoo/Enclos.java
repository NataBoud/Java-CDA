package org.example.Exo6GeneriqueZoo;

import org.example.Exo6GeneriqueZoo.animaux.Animal;

public class Enclos<T> {
    private T[] animaux;
    private int nbAnimaux = 0;

    public Enclos(int taille) {
        animaux = (T[]) new Animal[taille]; // Initialisation du tableau avec la taille définie
    }

    public void ajouterAnimal(T animal) {
        if (nbAnimaux < animaux.length) {
            animaux[nbAnimaux] = animal;
            nbAnimaux++;
            System.out.println("Animal ajouté : " + animal);
        }else {
            System.out.println("L'enclos est plein !");
        }
    }

    public String afficherAnimaux() {
        if (nbAnimaux == 0) {
            return "Aucun animal dans cet enclos.";
        }
        StringBuilder sb = new StringBuilder("Animaux dans l'enclos :\n");
        for (int i = 0; i < nbAnimaux; i++) {
            sb.append(animaux[i]).append("\n");
        }
        return sb.toString();
    }
}
