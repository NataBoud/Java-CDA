package org.example.DemoInterface;

public abstract class Produit {

    protected int id;
    protected float prix;
    protected String name;

    public Produit(int id, float prix, String name) {
        this.id = id;
        this.prix = prix;
        this.name = name;
    }
}
