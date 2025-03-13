package org.example.Exo7ListExeptionBilleterie.evenement;

import org.example.Exo7ListExeptionBilleterie.Client;

public class Billet {
    private int numeroPlace;
    private Client client;
    private Evenement evenement;
    private TypePlace typePlace;

    public Billet(int numeroPlace, Client client, Evenement evenement, TypePlace typePlace) {
        this.numeroPlace = numeroPlace;
        this.client = client;
        this.evenement = evenement;
        this.typePlace = typePlace;
    }

    public int getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public TypePlace getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(TypePlace typePlace) {
        this.typePlace = typePlace;
    }
}
