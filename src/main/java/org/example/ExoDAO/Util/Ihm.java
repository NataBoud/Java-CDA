package org.example.ExoDAO.Util;

import org.example.ExoDAO.DAO.IngredientDAO;
import org.example.ExoDAO.Entity.Ingredient;

import java.sql.SQLException;
import java.util.Scanner;

public class Ihm {
    private Scanner scanner;
    private IngredientDAO ingredientDAO;

    public Ihm() {
        scanner = new Scanner(System.in);
        ingredientDAO = new IngredientDAO();
    }

    public void start() throws SQLException {
        String entry ;
        while (true){
            showMenu();
            entry = scanner.nextLine();
            switch (entry){
               case "1" -> new IhmIngredient().start();
               case "2" -> new IhmCategorie().start();
               case "3" -> new IhmRecipe().start();
//                case "4" -> ;
            }
        }
    }

    private void showMenu (){
        System.out.println("""
                ---- RECETTES APP ----
                1/ Gestion des ingredients
                2/ Gestion des catégories
                3/ Gestion des recettes
                4/ ...
                """);
    }


}
