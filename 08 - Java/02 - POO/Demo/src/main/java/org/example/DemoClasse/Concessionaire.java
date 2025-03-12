package org.example.DemoClasse;

import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Concessionaire {

    private Voiture[] voitures;

    public Concessionaire() {
        this.voitures = new Voiture[10];
    }

    public void addVoiture(Voiture voiture){
        for(int i = 0 ; i< voitures.length; i++){
            if(voitures[i] == null){
                voitures[i] = voiture;
                break;
            }
        }
    }

    public void addVoiture(String model, String couleur, int reservoire, int autonomie){
        Voiture voiture = new Voiture(model, couleur,reservoire,autonomie);
        addVoiture(voiture);
    }

    public void show (){
        System.out.println(Arrays.toString(voitures));
    }
}
