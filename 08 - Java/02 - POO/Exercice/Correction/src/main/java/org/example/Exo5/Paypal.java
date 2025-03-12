package org.example.Exo5;

public class Paypal implements Paiement{

    private String email;
    private String mdp;

    public Paypal(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    @Override
    public String effectuerPaiment(double montant) {
        if(montant>0){
            return "Payement effectué via paypal d'un montant de : "+montant;
        }
        return "Payement impossible montant incorrecte";
    }
}
