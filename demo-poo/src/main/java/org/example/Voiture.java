package org.example;



public class Voiture {
    private String model;
    private String color;
    private int reservoir;
    private int autonomie;


    public Voiture() {};

    /**
     * *Constructeur de la voiture
     * @param model model de la voiture
     * @param color color de la voiture
     * @param reservoir reservoir de la voiture
     * @param autonomie autonomie de la voiture
     **/
    public Voiture(String model, String color, int reservoir, int autonomie) {
        this.model = model;
        this.color = color;
        this.reservoir = reservoir;
        this.autonomie = autonomie;
    }
    public void afficher() {
        System.out.printf("""
            Ma voiture est une : %S
            de couleur : %S
            reservoir : %S
            autonomie : %S
            """, model, color, reservoir, autonomie);
    }

//    public void demarer(){
//        if(demaree){
//            System.out.println();
//        }else
//    }


//    public String toString() {
//       return "Ma voiture est une : " + model +
//               "            de couleur : %S\n" +
//               "            reservoir : %S\n" +
//               "            autonomie : %S"
//    }

    @Override
    public String toString() {
        return "Voiture{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", reservoir=" + reservoir +
                ", autonomie=" + autonomie +
                '}';
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getReservoir() {
        return reservoir;
    }

    public int getAutonomie() {
        return autonomie;
    }
}
