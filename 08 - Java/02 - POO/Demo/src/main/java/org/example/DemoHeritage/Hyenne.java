package org.example.DemoHeritage;

public final class Hyenne extends Canide{
    public Hyenne(int age, String nom) {
        super(age, nom);
    }

    @Override
    public void crier() {
        System.out.println("La hyenne crie");
    }
}
