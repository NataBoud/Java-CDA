package org.example.DemoInterface;

public class ProduitBricolage extends Produit implements PeutBruler , Defaillant {
    public ProduitBricolage(int id, float prix, String name) {
        super(id, prix, name);
    }

    @Override
    public void Bruler() {
        System.out.println("Notre produit de bricolage brule");
    }

    @Override
    public void etteindre() {

    }

    @Override
    public void defaillant() {

    }
}
