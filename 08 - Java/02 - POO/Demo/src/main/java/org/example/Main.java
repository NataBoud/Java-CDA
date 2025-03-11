package org.example;

import org.example.DemoClasse.Voiture;

public class Main {
    public static void main(String[] args) {
        Voiture maVoiture = new Voiture("Voiture","rouge",12,12);

        maVoiture.afficher();

        maVoiture.demarer();
        maVoiture.demarer();

        maVoiture.getModel();

        String maVoitureStr = maVoiture.toString();

        System.out.println(maVoiture);

    }
}