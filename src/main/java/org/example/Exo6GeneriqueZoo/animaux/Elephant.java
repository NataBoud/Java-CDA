package org.example.Exo6GeneriqueZoo.animaux;

public class Elephant extends Animal {
    private String nom;
    private int age;
    private float poids;

    public Elephant(String nom, int age, float poids) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }


    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }


    @Override
    public String toString() {
        return "Elephant{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", poids=" + poids +
                '}';
    }
}
