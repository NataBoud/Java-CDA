package org.example;

public class Main {
    public static void main(String[] args) {
//        System.out.println(addition(12,15));
//        System.out.println( addition(12.8,15.6));
        int[] tab = {1,2,3,4,5};
        afficheArrays(tab);
        System.out.println(infinie());
    }


    public static String maFunc (int arg, String arg2 ){
        return arg2 + arg;
    }

    public static int addition (int a,int b){
        System.out.println("avec des ints");
        return a+b;
    }

    public static  double addition (double a,double b){
        System.out.println("avec des doubles");
        return a+b;
    }

    public static void afficheArrays (int[] arrays){
        for (int i : arrays){
            System.out.println(i);
        }
    }

    public static  int cpt = 0;

    public static int infinie(){
        System.out.println("dans ma function infinit");
        cpt++;
        if(cpt > 15){
            return cpt;
        }
        return infinie();
    }
}