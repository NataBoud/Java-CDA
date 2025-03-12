package org.example.DemoInterface;

public class ProduitAlimentaire extends Produit implements Defaillant {

    public ProduitAlimentaire(int id, float prix, String name) {
        super(id, prix, name);
    }

    @Override
    public void defaillant() {

    }
}
