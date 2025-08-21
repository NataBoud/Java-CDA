package org.example.Util;

import org.example.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private final Scanner scanner;
    private List<Event> events;
    private List<Customer> customers;

    public Ihm() {
        scanner = new Scanner(System.in);
    }

    private void init (){
        events = new ArrayList<>();
        customers = new ArrayList<>();

        Address address = new Address("200 rue des lillas","lille");
        Place place = new Place("rue de l'evenement","lille",800);

        Customer customer = new Customer("toto","tata",address,30,"01234567899");
        Customer customer2 = new Customer("titi","tutu",address,30,"01234567899");

        Event event = new Event("Event1",place, LocalDateTime.now(),400);

        customers.add(customer);
        customers.add(customer2);
        events.add(event);
    }


    public void start (){
        init();
        String entry;
        while (true){
            afficheMenu();
            entry = scanner.nextLine();
            switch (entry){
                case "1":
                    new IhmBillet(scanner,events,customers).start();
                    break;
                case "2":
                    new IhmCustomer(scanner,customers).start();
                    break;
                case "3":
                    new IhmEvent(scanner,events).start();
                    break;
                default:
                    return;
            }
        }


    }


    private void afficheMenu (){
        System.out.println("""
                --- Main Menu ---
                1/ Billet Menu
                2/ Customer Menu
                3/ Event Menu
                """);
    }








}
