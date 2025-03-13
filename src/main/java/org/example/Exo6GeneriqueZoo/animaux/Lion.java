package org.example.Exo6GeneriqueZoo.animaux;

public class Lion extends Animal {
    public Lion(String nom, int age) {
        super(nom, age);
    }

    @Override
    public void manger() {
        System.out.printf("""
                %s à manger
                   .~ ~ ~.
                 (  o,,,o  )
                (   ). .(   )
                 \\  { v }  /
                   ~ `v' ~
                """, nom);
    }

    @Override
    public void dormir() {
        System.out.printf("""
                    Z   %s s'est endormi
                  Z     @|\\@@
                    z  -  @@@@
                      /7   @@@@
                     /    @@@@@@
                     \\-' @@@@@@@@`-_______________
                      -@@@@@@@@@             /    \\
                 _______/    /_       ______/      |__________-
                /,__________/  `-.___/,_____________----------_)
                """, nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.printf("""
                %s à rugi
                                .,  ,.                       ,.
                              ,((')/))).                    (()
                             '(.(()( )")),                ((())
                           "___/,  "/)))/).'               .))
                           '.-.   "(()(()()/^             ( (
                 >> ROAR << ' _)   /)()())(()'______.---._.' )
                             '.   _  (()(()))..            ,'
                               (() \\  ()) ())(             )
                                   ((                .     /_
                                   /       \\,     .-(     (_ )
                                 .'   \\/    )___.'   \\      )
                                /    \\-    /        _/'.-'  /
                               (,(,.'     ))       (_ /    /
                                  (,(,(,_)         (,(,(,_)
                """, nom);
    }
}
