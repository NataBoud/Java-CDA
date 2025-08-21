package org.example.DemoException;

import org.example.DemoException.exception.MontantNegatifException;
import org.example.DemoException.exception.SoldeInsuffisantException;
import org.example.DemoException.exception.ValueIsNullException;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            int value = scanner.nextInt();
//        }catch (InputMismatchException ex){
//            System.out.println("Entrer une valeur numerique");
//        }
//
//        try{
//            math();
//        }catch (Exception ex){
//            System.out.println("exception levé");
//            System.out.println(ex.getMessage());
//        }


        Compte cp=new Compte();
        Scanner clavier = new Scanner(System.in);
        try {

            System.out.print("Montant à verser:");
            float mt1 = clavier.nextFloat();
            cp.verser(mt1);
            System.out.println("Solde Actuel:" + cp.getSolde());
            System.out.print("Montant à retirer:");
            float mt2 = clavier.nextFloat();
            cp.retirer(mt2);
        }
        catch (SoldeInsuffisantException | MontantNegatifException e ) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Problème de saisie");
        }
        catch(Exception e){
            System.out.println( "Catch de Exception");
        }
        finally {
            clavier.close();
        }



        System.out.println("Solde Final "+cp.getSolde());


    }



    public static void math () throws Exception{
        System.out.println(calcul(12,0));
        System.out.println("calcul efectué");
    }

    public static int calcul (int a, int b) throws Exception{
        if(b == 0){
            throw new ValueIsNullException("B equals 0");
        }
        return a/b;
    }
}
