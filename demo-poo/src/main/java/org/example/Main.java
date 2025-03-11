package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Voiture maVoiture = new Voiture("voiture", "red", 30, 30 );

        maVoiture.afficher();
        System.out.println(maVoiture);
    }
}