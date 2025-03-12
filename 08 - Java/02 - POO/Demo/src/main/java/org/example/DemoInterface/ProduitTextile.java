package org.example.DemoInterface;

public class ProduitTextile extends Produit implements PeutBruler{
    public ProduitTextile(int id, float prix, String name) {
        super(id, prix, name);
    }

    @Override
    public void Bruler() {

    }

    @Override
    public void etteindre() {

    }
}
