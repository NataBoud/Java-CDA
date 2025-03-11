package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("entrer une chaine de charactere :");
        String chaine = scanner.nextLine();
        System.out.printf("le charactere a apparais %d foix",compterLettre(chaine,'a'));
    }


    public static int compterLettreA (String chaine){
        int cpt =0;
        for(char lettre : chaine.toCharArray()){
            if(Character.toLowerCase(lettre) == 'a'){
                cpt ++;
            }
        }
        return cpt;
    }

    public static int compterLettre(String chaine, char lettre){
        int cpt =0;
        for(char chars : chaine.toCharArray()){
            if(Character.toLowerCase(chars) == lettre){
                cpt ++;
            }
        }
        return cpt;
    }
}