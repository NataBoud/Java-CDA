package org.example.DemoGenerique;

public class main {
    public static void main(String[] args) {
        GestionaireProduit<ProduitAlimentaire> gestionaireProduitAlimentaire = new GestionaireProduit<>();

        gestionaireProduitAlimentaire.addToBDD(new ProduitAlimentaire(25,"produit1"));




        GestionaireProduit<ProduitMenager> gestionaireProduitMenager = new GestionaireProduit<>();

        gestionaireProduitMenager.addToBDD(new ProduitMenager(25,"produit2"));
        gestionaireProduitMenager.getProduit();



        Integer[] integers =new Integer[]{1,2,3};
        ProduitMenager[] produitMenagers = new ProduitMenager[]{
                new ProduitMenager(25,"produit2"),new ProduitMenager(25,"produit2")
                ,new ProduitMenager(25,"produit2"),new ProduitMenager(25,"produit2")
        };

        Util.printArray(integers);

    }
}
