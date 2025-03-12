package org.example.Exo3;

public class Arbre extends Plante {

    private float circonference;

    public Arbre(String nom, float hauteur, String couleur,float circonference) {
        super(nom, hauteur, couleur);
        this.circonference = circonference;
    }

    public float getCirconference() {
        return circonference;
    }

    public void setCirconference(float circonference) {
        if(circonference>0){
            this.circonference = circonference;
        }
    }

    @Override
    public String toString() {
        return super.toString()+
                "circonference=" + circonference;
    }
}
