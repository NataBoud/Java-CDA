package org.example.Util;

import org.example.Exception.ToMuchBilletException;
import org.example.model.Billet;
import org.example.model.Customer;
import org.example.model.Event;

import java.util.List;
import java.util.Scanner;

public class IhmBillet {
    private final Scanner scanner;
    private final List<Event> events;
    private final List<Customer> customers;

    public IhmBillet(Scanner scanner, List<Event> events, List<Customer> customers) {
        this.scanner = scanner;
        this.events = events;
        this.customers = customers;
    }

    public void start(){
        String entry;
        while (true){
            afficheMenu();
            entry = scanner.nextLine();
            switch (entry){
                case "1":
                    addBillet();
                    break;
                case "2":
                    showBilletCustomer();
                    break;
                case "3":
                    showBilletEvent();
                    break;
                default:
                    return;
            }
        }
    }

    private void afficheMenu (){
        System.out.println("""
                --- Menu des billets ---
                1/ cree un billet
                2/ aficher les billets d'un client
                3/ afficher les billets d'un event
                """);
    }

    private void addBillet (){
        System.out.println("--- ajout d'un billet ---");

        System.out.println(customers);
        System.out.println("index du client :");
        int indexClient = scanner.nextInt();
        scanner.nextLine();

        System.out.println(events);
        System.out.println("index de l'evenement :");
        int indexEvent = scanner.nextInt();
        scanner.nextLine();
        PlaceTYpe placeTYpe = null;

        boolean test = true;
        while(test){
            try{
                System.out.println("Type de la place Standard/ gold / vip");
                String typePlace = scanner.nextLine();
                 placeTYpe = PlaceTYpe.valueOf(typePlace.toUpperCase());
                test = false;
            }catch (IllegalArgumentException ex){
                System.out.println("entrer une valeur valide");
            }
        }


        Customer customer = customers.get(indexClient);
        Event event = events.get(indexEvent);
        int numerosPlace = event.getBillets().size() + 1;

        try{
            Billet billet = new Billet(numerosPlace,customer,event,placeTYpe);
            event.addBillet(billet);
            customer.addBillet(billet);
        }catch (ToMuchBilletException ex){
            System.out.println(ex.getMessage());
        }

    }

    private void showBilletCustomer(){
        System.out.println("--- affiher les billets d'un client ---");
        System.out.println("index du client :");
        int index = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customers.get(index);
//        for (Billet billet : customer.getBillets()){
//            System.out.println(billet);
//        }
        customer.getBillets().forEach(System.out::println);
        customer.getBillets().forEach(billet -> System.out.println(billet));

    }
    private void showBilletEvent(){
        System.out.println("--- affiher les billets d'un Evenement ---");
        System.out.println("index de l'evenement :");
        int index = scanner.nextInt();
        scanner.nextLine();
        Event event = events.get(index);
        for (Billet billet : event.getBillets()){
            System.out.println(billet);
        }
    }
}
