package org.example.DemoException;

import org.example.DemoException.exception.MontantNegatifException;
import org.example.DemoException.exception.SoldeInsuffisantException;

public class Compte {
    private float solde;

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public void verser (float mt){
        if(mt < 0 ) throw new MontantNegatifException("Montant du versement negatif ou null");
        solde += mt;
    }

    public void retirer (float mt){
        if(mt < 0 ) throw new MontantNegatifException("Montant du versement negatif ou null");
        if(mt > solde) throw new SoldeInsuffisantException("Solde insufisant pour la transaction : "+solde);
        solde -= mt;
    }
}
