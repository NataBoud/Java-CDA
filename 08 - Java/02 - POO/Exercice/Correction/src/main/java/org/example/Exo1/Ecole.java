package org.example.Exo1;

public class Ecole {

    private int nbrEnfant;
    private int nbrclasse;
    private int nbrProfesseur;

    public Ecole (){

    }

    public Ecole(int nbrclasse,int nbrEnfant,int nbrProfesseur){
        this.nbrclasse =nbrclasse;
        this.nbrEnfant = nbrEnfant;
        this.nbrProfesseur = nbrProfesseur;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public int getNbrclasse() {
        return nbrclasse;
    }

    public void setNbrclasse(int nbrclasse) {
        this.nbrclasse = nbrclasse;
    }

    public int getNbrProfesseur() {
        return nbrProfesseur;
    }

    public void setNbrProfesseur(int nbrProfesseur) {
        this.nbrProfesseur = nbrProfesseur;
    }

    public int nombreEnfantParClasse (){
        return nbrEnfant/nbrclasse;
    }

    public int nombreEnfantParProfesseur(){
        return nbrEnfant/nbrProfesseur;
    }

    @Override
    public String toString() {
        return "Ecole{" +
                "nbrEnfant=" + nbrEnfant +
                ", nbrclasse=" + nbrclasse +
                ", nbrProfesseur=" + nbrProfesseur +
                " Nombre d'efant par classe :" + nombreEnfantParClasse()+
                " Nombre d'enfant par professeur : "+nombreEnfantParProfesseur()+
                '}';
    }
}
