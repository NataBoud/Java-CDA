package org.example.Exo2;

public class MainJoueur {
    public static void main(String[] args) {
        Joueur joueur = new Joueur("Joueur1");

        joueur.validerQuete(120);

        joueur.validerQuete(20);

        Joueur joueur1 = new Joueur("Joueur2");

        joueur1.validerQuete(54);

        System.out.println( "il y a "+Joueur.getNbJoueur()+ " joueur cree");
    }
}
