package org.example;

import org.example.DemoClasse.Concessionaire;
import org.example.DemoClasse.Voiture;

public class Main {
    public static void main(String[] args) {
        Voiture maVoiture = new Voiture("Voiture","rouge",12,12);
//
//        maVoiture.afficher();
//
//        maVoiture.demarer();
//        maVoiture.demarer();
//
////        System.out.println(maVoiture);
//
        Voiture maVoiture2 = new Voiture("model", "Jaune");
//
//        System.out.println(maVoiture2);
//        System.out.println(Voiture.getNbVoiture());
//
//        System.out.println(maVoiture);

        Concessionaire concessionaire = new Concessionaire();
        concessionaire.addVoiture(maVoiture);
        concessionaire.addVoiture(maVoiture2);
        concessionaire.addVoiture("Voiture3","Bleu",158,2000);

        concessionaire.show();


    }
}