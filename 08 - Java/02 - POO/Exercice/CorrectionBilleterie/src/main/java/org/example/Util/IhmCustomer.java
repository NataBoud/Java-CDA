package org.example.Util;

import org.example.model.Address;
import org.example.model.Customer;
import org.example.model.Event;
import org.example.model.Place;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class IhmCustomer {
    private final Scanner scanner;
    private final List<Customer> customers;

    public IhmCustomer(Scanner scanner, List<Customer> customers) {
        this.scanner = scanner;
        this.customers = customers;
    }

    public void start(){
        String entry;
        while (true){
            afficheMenu();
            entry = scanner.nextLine();
            switch (entry){
                case "1":
                    addCustomer();
                    break;
                case "2":
                    updateCustomer();
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
                --- Customer Menu ---
                1/ Add Customer
                2/ Update Customer
                3/ Remove Customer
                """);
    }

    private void addCustomer (){
        System.out.println("--- Add Customer ---");

        System.out.println("Firstname :");
        String firstname = scanner.nextLine();
        System.out.println("Lastname :");
        String lastname = scanner.nextLine();

        System.out.println("--- Address creation ---");
        System.out.println("street :");
        String street = scanner.nextLine();
        System.out.println("City :");
        String city = scanner.nextLine();

        Address address = new Address(street,city);

        System.out.println("age :");
        int age = scanner.nextInt();

        System.out.println("Phone Number :");
        String phone = scanner.nextLine();


        Customer customer = new Customer(firstname,lastname,address,age,phone);
        customers.add(customer);
    }

    private void updateCustomer (){
        System.out.println("--- Update Customer ---");

        for(int i =0;i<customers.size();i++){
            Customer customer = customers.get(i);
            System.out.println(i+ ": "+customer.getFirstName()+" "+customer.getLastName());
        }

        System.out.println("Select customer id :");
        int id = scanner.nextInt();

        if(id>= customers.size()){
            System.out.println("id out of range ");
            return;
        }

        Customer customer = customers.get(id);

        System.out.println("Firstname : ("+customer.getFirstName()+")");
        String firstname = scanner.nextLine();
        customer.setFirstName(firstname.isEmpty()? customer.getFirstName():firstname);
        System.out.println("Lastname : ("+customer.getLastName()+")");
        String lastname = scanner.nextLine();
        customer.setLastName(lastname.isEmpty()? customer.getLastName():lastname);

        System.out.println("--- Address creation ---");
        System.out.println("street : ("+customer.getAddress().getStreet()+")");
        String street = scanner.nextLine();
        customer.getAddress().setStreet(street.isEmpty()? customer.getAddress().getStreet():street);
        System.out.println("City : ("+customer.getAddress().getCity()+")");
        String city = scanner.nextLine();
        customer.getAddress().setCity(city.isEmpty()? customer.getAddress().getCity():city);

        System.out.println("age : ("+customer.getAge()+")");
        int age = scanner.nextInt();
        customer.setAge(age == 0? customer.getAge():age);


        System.out.println("Phone Number : ("+customer.getTelephone()+")");
        String phone = scanner.nextLine();
        customer.setTelephone(phone.isEmpty()? customer.getTelephone():phone);

        System.out.println("Customer Update*");
    }
}
