package org.example.Exo6.Animaux;

public abstract class Animal {
    protected String nom;
    protected int age;

    public Animal(String nom, int age) {
        this.nom = nom;
        this.age = age;
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

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void manger();
    public abstract void dormir();
    public abstract void faireDuBruit();

    @Override
    public String toString() {
        return String.format("%s %dan%s", nom, age, (age > 1 ? "s": ""));
    }
}
