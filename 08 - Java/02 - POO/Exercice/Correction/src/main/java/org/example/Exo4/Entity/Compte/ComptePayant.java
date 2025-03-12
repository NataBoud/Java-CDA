package org.example.Exo4.Entity.Compte;

import org.example.Exo4.Entity.Client;
import org.example.Exo4.Entity.Operation;
import org.example.Exo4.Entity.Statut;

public class ComptePayant extends CompteBancaire{

    private double cout;

    public ComptePayant(double solde, Client client,double cout) {
        super(solde, client);
        this.cout = cout   ;
    }

    @Override
    public void retrait(double montant) {
        montant += cout;
        if(solde>= montant){
            solde -= montant;
            addOperation(new Operation(montant, Statut.RETRAIT));
        }
    }

    @Override
    public void depot(double montant) {
        montant -= cout;
        if(montant>0){
            solde += montant;
            addOperation(new Operation(montant,Statut.DEPOT));
        }
    }
}
