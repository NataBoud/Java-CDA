package org.example.Exo4.Entity.Compte;

import org.example.Exo4.Entity.Client;
import org.example.Exo4.Entity.Operation;

import java.util.Arrays;

public abstract class CompteBancaire {
    protected double solde ;
    protected Client client;
    protected final Operation[] listOperation;

    public CompteBancaire(double solde, Client client) {
        this.solde = solde;
        this.client = client;
        listOperation = new Operation[50];
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Operation[] getListOperation() {
        return listOperation;
    }

    public void addOperation(Operation operation){
        for(int i = 0 ; i< listOperation.length ; i++){
            if(listOperation[i] == null){
                listOperation[i] = operation;
                break;
            }
        }
    }

    public abstract void retrait (double montant);
    public abstract void depot (double montant);

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "solde=" + solde +
                ", client=" + client +
                ", listOperation=" + Arrays.toString(listOperation) +
                '}';
    }
}
