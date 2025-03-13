package org.example.Exo6GeneriqueZoo.animaux;

public class Elephant extends Animal {

    private float poids;

    public Elephant(String nom, int age, float poids) {
        super(nom, age);
        this.poids = poids;
    }




    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    @Override
    public void manger() {
        System.out.printf("""
                %s à mangé
                 __
                '. \\
                 '- \\
                  / /_         .---.
                 / | \\\\,.\\/--.//    )
                 |  \\//        )/  /
                  \\  ' ^ ^    /    )____.----..  6
                   '.____.    .___/            \\._)
                      .\\/.                      )
                       '\\                       /
                       _/ \\/    ).        )    (
                      /#  .!    |        /\\    /
                      \\  C// #  /'-----''/ #  /
                   .   'C/ |    |    |   |    |     ,
                   \\), .. .'OOO-'. ..'OOO'OOO-'. ..\\(,
                """, nom);
    }

    @Override
    public void dormir() {
        System.out.printf("""
                %s s'est endormi
                         ___     _,.--.,_
                Z     .-~   ~--"~-.   ._ "-.
                  Z  /      ./_    Y    "-. \\
                 z  Y       :~     !         Y
                    l= =    |     /         .|
                 _   \\. .-, l    /          |j
                ()\\___) |/   \\_/";          !
                 \\._____.-~\\  .  ~\\.      ./
                            Y_ Y_. "vr"~  T
                            (  (    |L    j
                            [nn[nn..][nn..]
                        ~~~~~~~~~~~~~~~~~~~~~~~
                """, nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.printf("""
                %s à barri
                       , >>poot<<
                     ((_,-.
                      '-.\\_)'-,
                         )  _ )'-
                ,.;.,;,,(/(/ \\));,;.,.,
                """, nom);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2fkg", poids);
    }
}
