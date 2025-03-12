package org.example.Exo4.Entity.Compte;

import org.example.Exo4.Entity.Client;
import org.example.Exo4.Entity.Operation;
import org.example.Exo4.Entity.Statut;

public class CompteEpargne extends CompteBancaire{

    private double taux;

    public CompteEpargne(double solde, Client client,double taux ) {
        super(solde, client);
        this.taux = taux;
    }

    @Override
    public void retrait(double montant) {
        if(solde>= montant){
            solde -= montant;
            addOperation(new Operation(montant, Statut.RETRAIT));
        }
    }

    @Override
    public void depot(double montant) {
        if(montant>0){
            solde += montant;
            addOperation(new Operation(montant,Statut.DEPOT));
        }
    }

    public String getEpargneCalcul (){
        return "Epargne";
    }
}
