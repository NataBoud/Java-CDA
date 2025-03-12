package org.example.DemoHeritage;

public abstract sealed class Animal permits Canide  {
    protected int age;
    private static int nbAnimaux;

    public Animal(int age) {
        this.age = age;
        nbAnimaux++;
    }

    public abstract void crier();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNbAnimaux() {
        return nbAnimaux;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName()+ "{" +
                "age=" + age +
                '}';
    }
}
