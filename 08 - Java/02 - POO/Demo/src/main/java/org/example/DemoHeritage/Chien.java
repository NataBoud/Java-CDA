package org.example.DemoHeritage;

public final class Chien extends Canide{

    private String race;

    public Chien(int age, String nom,String race) {
        super(age, nom);
        this.race =race;
    }

    public void aboyer (){
        System.out.println("le chien aboit");
    }

    @Override
    public void crier() {
        System.out.println("le chien crie");
    }

    @Override
    public String toString() {
        return super.toString() +
                "race='" + race + '\'' +
                '}';
    }
}
