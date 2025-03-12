package org.example.DemoClasse;


/**
* Ma classe voiture
**/
public class Voiture {

    private String model;
    private String couleur;
    private int reservoir;
    private int autonomie;
    private boolean demaree;

    private static int nbVoiture;





    /**
     * Constructeur de la voiture
     * @param model model de la voiture
     * @param paramCouleur couleur de la voiture
     * @param reservoir contenance du reservoire
     * @param autonomie autonomie de la voiture
     */
    public Voiture (String model,String paramCouleur,int reservoir,int autonomie){
        this(model,paramCouleur);
        this.reservoir = reservoir;
        this.autonomie =autonomie;
    }

    public Voiture(String model, String couleur) {
        this();
        this.model = model;
        this.couleur = couleur;

    }

    public Voiture (){
        nbVoiture++;
    }

    public void afficher (){
        System.out.printf("""
                Ma voiture et une : %s
                de couleur %s
                avec un reservoir de %d litre
                et une autonomie de %d heure
                """,model,couleur,reservoir,autonomie);
    }

    public void demarer(){
        if(demaree){
            System.out.println("Moteur deja demaré");
        }else{
            System.out.println("Le moteur demare");
            demaree = true;
        }
    }


    /**
     *
     * @return renvois le model de notre voiture
     */
    public String getModel (){
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReservoir() {
        return reservoir;
    }

    public void setReservoir(int reservoir) {
        this.reservoir = reservoir;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    public boolean isDemaree() {
        return demaree;
    }

    public void setDemaree(boolean demaree) {
        this.demaree = demaree;
    }

    public static int getNbVoiture() {
        return nbVoiture;
    }


    /*    public String toString(){
        return "Ma voiture et une : "+model+
                "de couleur "+couleur+"avec un reservoir de "+reservoir +"litre et une autonomie de"+autonomie+"heure";
    }*/

    @Override
    public String toString() {
        return "Voiture{" +
                "model='" + model + '\'' +
                ", couleur='" + couleur + '\'' +
                ", reservoir=" + reservoir +
                ", autonomie=" + autonomie +
                ", demaree=" + demaree +
                "nombre de voiture : " + nbVoiture +
                '}';
    }

}
