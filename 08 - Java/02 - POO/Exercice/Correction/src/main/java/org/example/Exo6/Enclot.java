package org.example.Exo6;

import org.example.Exo6.Animaux.Animal;

import java.util.ArrayList;
import java.util.List;

public class Enclot<T extends Animal>{

    private final List<T> animaux;

    public Enclot() {
        animaux = new ArrayList<>();
    }

    public void ajouterAnimal(T animal) {
        animaux.add(animal);
        System.out.printf(
                "%s à été ajouter à l'enclos des animaux qui compte maintenant %d membre%s!\n",
                animal.getNom(), animaux.size(), (animaux.size()>1? "s" : "")
        );
    }

    public void afficherAnimaux() {
        System.out.println(animaux);
    }



}
