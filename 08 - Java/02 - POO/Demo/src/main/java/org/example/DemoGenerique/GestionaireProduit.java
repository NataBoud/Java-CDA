package org.example.DemoGenerique;

public class GestionaireProduit<T> {


    public void addToBDD(T produit){
        System.out.println("produit ajouter a la base de donée"+produit);
    }

    public T getProduit (){
        System.out.println("recuperation du produit ");
        return null;
    }


}
