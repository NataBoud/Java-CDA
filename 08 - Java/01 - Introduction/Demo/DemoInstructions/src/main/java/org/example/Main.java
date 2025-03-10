package org.example;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("entrer votre age : ");
//        int value = scanner.nextInt();
//
//        if(value >=18){
//            System.out.println("Vous etes majeur");
//        }else
//            System.out.println("Vous etes mineur");


//        switch (value){
//            case 1,2,3,4:
//                System.out.println("vous avez entre 1 et 4 ans");
//                break;
//            case 7,8,9,10:
//                System.out.println("vous avez entre 7 et 10 ans");
//                break;
//            default:
//                System.out.println("vous avez plus de 10 ans");
//                break;
//        }

//        switch (value){
//            case 1,2,3,4 -> System.out.println("vous avez entre 1 et 4 ans");
//            case 7,8,9,10 -> System.out.println("vous avez entre 7 et 10 ans");
//            default ->  System.out.println("vous avez plus de 10 ans");
//        }

        int[] tableau = new int[] {1,2,3,4,5,6,7,8,9};

//        for (int i = 0; i< tableau.length; i++){
//            System.out.println("ma "+i+" eme valeur est : "+tableau[i]);
//        }

        for(int value : tableau){
            System.out.println("ma valeur est : " + value);
        }


        int i =0;
        while(true){
            if(i>15){
                break;
            }
            i++;
            System.out.println(i);
        }

        do {
          i++;
          System.out.println("do" +i);
        }while (i>20);

        Random ramdom = new Random();

        ramdom.nextInt(100);
    }
}