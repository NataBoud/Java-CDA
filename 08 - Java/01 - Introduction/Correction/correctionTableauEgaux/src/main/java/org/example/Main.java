package org.example;


public class Main {
    public static void main(String[] args) {

        int[] tab1 = {1,2,3,4};
//        int[] tab2 = {1,2,3,4};
        int[] tab2 = {1,2,4,3};

        boolean isEquals = true;

        if(tab1.length == tab2.length){

            for(int i =0;i<tab1.length;i++){
                if(tab1[i] != tab2[i]){
                    isEquals = false;
                }
            }
        }else{
            System.out.println("Les tableau ne sont pas égaux");
        }

        if(isEquals){
            System.out.println("Les tableaux sont egaux");
        }else{
            System.out.println("Les tableau ne sont pas égaux");
        }


    }
}