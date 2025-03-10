package org.example;


import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int nombreMystere = random.nextInt(100);

        int valueUser ;
        int tentative = 0;
        do{
            System.out.println("Saisir un nombre");
            valueUser = scanner.nextInt();
            if(valueUser < nombreMystere){
                System.out.println("Le nombre est plus grand");
            } else if (valueUser > nombreMystere) {
                System.out.println("Le nombre est plus petit");
            }
            tentative++;
        }while (valueUser != nombreMystere && tentative < 5);

/*        while (valueUser != nombreMystere && tentative < 5){
            System.out.println("Saisir un nombre");
            valueUser = scanner.nextInt();
            if(valueUser < nombreMystere){
                System.out.println("Le nombre est plus grand");
            } else if (valueUser > nombreMystere) {
                System.out.println("Le nombre est plus petit");
            }
            tentative++;
        }*/

        if(tentative<5){
            System.out.printf("Vous avez trouver le nombre mystere en %d",tentative);
        }else{
            System.out.println("vous n'avez pas trouver la valeur du nombre mystere qui ete : "+nombreMystere);
        }


    }
}