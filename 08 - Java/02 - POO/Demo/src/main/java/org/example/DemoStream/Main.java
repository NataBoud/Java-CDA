package org.example.DemoStream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Pomme","Banane","Ananas","Poire","Orange");

        List<String> listSorted = list.stream().sorted().toList();
        System.out.println(listSorted);


        List<Personne> personnes = Arrays.asList(new Personne("toto",12,"12334456"),
                new Personne("titi",20,"3246790089"),
                new Personne("tutu",22,"3247856749"),
                new Personne("tata",55,"3246758689"),
                new Personne("toto",12,"12334456"),
                new Personne("titi",20,"3246790089"),
                new Personne("tutu",22,"3247856749"),
                new Personne("tata",55,"3246758689"));

        OptionalDouble moyenneAge = personnes.stream()
                .mapToInt(Personne::getAge)
                .average();

        if(moyenneAge.isPresent())
            System.out.println(moyenneAge.getAsDouble());

//        Map<String,Long> PersonnesByName =
        personnes.stream()
                .collect(Collectors.groupingBy(Personne::getName,Collectors.counting()))
                .forEach((key,value)-> System.out.println("key :"+key+" Value : "+value));


    }
}
