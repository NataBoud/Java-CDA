package org.example;


public class Main {
    public static void main(String[] args) {

//            int[] tab = new int[8];
            int[] tab = {2,4,6,8,10,12};
            int[] tab2 = new int[7];

            String[] tabStr = {"one","two","three"};



//        for (int i = 0;i<tab.length;i++){
//            tab2[i] = tab[i];
//        }
//        tab2[6] = 25;
//
//        System.out.println(tab2[4]);
//
//        for (int i : tab2){
//            System.out.println(i);
//        }

        String[][] tableaudenom = {
                {"toto","tata"},
                {"titi","tutu"}
        };

        for (String[] tabNomPersonne: tableaudenom){
            System.out.println("Affichage des nom : ");
            for (String nom : tabNomPersonne){
                System.out.println(nom);
            }
        }
    }
}