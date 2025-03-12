package org.example.DemoHeritage;

public abstract sealed class Canide  extends Animal permits Chien , Hyenne{

    protected String nom;

    public Canide(int age,String nom) {
        super(age);
        this.nom = nom;
    }

    @Override
    public String toString() {
        return super.toString()+

                "nom='" + nom + '\'' +
                '}';
    }
}
