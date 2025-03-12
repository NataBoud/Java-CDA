package org.example.Exo5;

import java.time.LocalDate;

public class CarteDeCredit implements Paiement {

    private String numeroDeCarte;
    private String titulaire;
    private LocalDate dateExpiration;
    private int cvv;

    public CarteDeCredit(String numeroDeCarte, String titulaire, LocalDate dateExpiration, int cvv) {
        this.numeroDeCarte = numeroDeCarte;
        this.titulaire = titulaire;
        this.dateExpiration = dateExpiration;
        this.cvv = cvv;
    }

    @Override
    public String effectuerPaiment(double montant) {
        if(montant>0){
            return "Payement effectué via la carte de credit d'un montant de : "+montant;
        }
        return "Payement impossible montant incorrecte";
    }
}
