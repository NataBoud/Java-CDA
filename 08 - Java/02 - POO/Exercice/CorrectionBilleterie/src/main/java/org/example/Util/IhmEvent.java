package org.example.Util;

import org.example.Exception.IncorectNumberOfPlaceException;
import org.example.model.Billet;
import org.example.model.Customer;
import org.example.model.Event;
import org.example.model.Place;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class IhmEvent {

    private final Scanner scanner;
    private final List<Event> events;

    public IhmEvent(Scanner scanner, List<Event> events) {
        this.scanner = scanner;
        this.events = events;
    }

    public void start(){
        String entry;
        while (true){
            afficheMenu();
            entry = scanner.nextLine();
            switch (entry){
                case "1":
                    addEvent();
                    break;
                case "2":
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    break;
                default:
                    return;
            }
        }
    }

    private void afficheMenu (){
        System.out.println("""
                --- Event Menu ---
                1/ Add Event
                2/ Update Event
                3/ Remove Event
                """);
    }

    private void addEvent (){
        System.out.println("--- Add Event ---");

        System.out.println("Event Name :");
        String eventName = scanner.nextLine();

        System.out.println("--- Place creation ---");
        System.out.println("street :");
        String street = scanner.nextLine();
        System.out.println("City :");
        String city = scanner.nextLine();
        System.out.println("Capacity :");
        int capacity = scanner.nextInt();

        Place place = new Place(street,city,capacity);

        System.out.println("Date : (format : dd-MM-yyyy HH:mm:ss");
        String dateStr = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(dateStr,formatter);

        System.out.println("Number of place :");
        int numberOfPlace = scanner.nextInt();

        try {
            Event event = new Event(eventName, place, date, numberOfPlace);
            events.add(event);
        }catch (IncorectNumberOfPlaceException ex){
            System.out.println(ex.getMessage());
        }

    }


}
