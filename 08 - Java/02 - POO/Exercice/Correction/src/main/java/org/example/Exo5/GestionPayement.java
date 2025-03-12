package org.example.Exo5;

import java.time.LocalDate;

public class GestionPayement {
    public static void main(String[] args) {
        Paiement[] paiements = new Paiement[]{
                new CarteDeCredit("0000-0000-0000-0000","Titulaire", LocalDate.of(2028,12,12),888),
                new CarteDeCredit("1111-1111-1111-1111","Titulaire", LocalDate.of(2028,12,11),444),
                new Paypal("titulaire@mail.com","pa$$word")
        };

        for(Paiement paiement : paiements){
            System.out.println(paiement.effectuerPaiment(50));
            System.out.println(paiement.effectuerPaiment(0));
        }
    }
}
