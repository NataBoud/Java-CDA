package org.example.DemoCollection;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        //List

        List<String> stringList = new ArrayList<>();

        stringList.add("Tomate");
        stringList.add("Fromage");
        stringList.add("Farine");


        List<String> listStr = List.of("tomate","fromage","farine");
//        List<String> listStr = List.of("tomate","fromage","farine",new Customer(12,"toto"),new Customer(12,"tata"));

//        stringList.remove(1);
        stringList.remove("Fromage");

        System.out.println("--- for each ---");
        for (String str : stringList){
            System.out.println(str);
        }

        System.out.println("--- For ---");
        for(int i = 0; i<listStr.size();i++){
            System.out.println(listStr.get(i));
        }


        //Set

        System.out.println("--- Set ---");
        Set<Integer> intergerSet = new HashSet<>();
//        Set<Integer> intergerSet = Set.of(1,2,3,45,6);

        intergerSet.add(1);
        intergerSet.add(2);
        intergerSet.add(3);
        intergerSet.add(1);

        for(Integer i : intergerSet){
            System.out.println(i);
        }



        //Map

        System.out.println("--- Map ---");

        Map<String,Integer> map = new HashMap<>();

        map.put("Pomme",4);
        map.put("Poire",2);
        map.put("Banane",5);

        map.replace("Pomme",10);

        map.remove("Poire");

        System.out.println(map);

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("Key :"+entry.getKey() + " Value : "+ entry.getValue());
        }



    }
}
