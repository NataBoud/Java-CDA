package org.example.Exo2;

public class Joueur {

    private String nom;
    private int niveau;
    private int experience;

    private static int nbJoueur;

    public Joueur() {
        nbJoueur++;
    }

    public Joueur(String nom) {
        this();
        this.nom = nom;
    }

    public Joueur(String nom, int niveau, int experience) {
        this(nom);
        this.niveau = niveau;
        this.experience = experience;
    }

    public void validerQuete (int experience){
        this.experience += experience;
        System.out.println("L'experience du joueur est de "+experience);
        monterNiveau();
    }

    private void monterNiveau(){
        if(experience>=100){
            experience -= 100;
            niveau++;
            System.out.println("le joueur est niveau "+niveau);
        }
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public static int getNbJoueur() {
        return nbJoueur;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", experience=" + experience +
                ", nbJoueur=" + nbJoueur +
                '}';
    }
}
