package org.example.ExoDAO.Util;

import org.example.ExoDAO.DAO.IngredientDAO;
import org.example.ExoDAO.Entity.Ingredient;

import java.util.List;
import java.util.Scanner;

public class IhmIngredient {
    private Scanner scanner;
    private IngredientDAO ingredientDAO;

    public IhmIngredient() {
        scanner = new Scanner(System.in);
        ingredientDAO = new IngredientDAO();
    }

    public void start(){
        String entry ;
        while (true){
            showMenu();
            entry = scanner.nextLine();
            switch (entry) {
                case "1" -> showIngredients();
                case "2" -> createIngredient();
                case "3" -> updateIngredient();
                case "4" -> deleteIngredient();
                case "q" -> {
                    return;
                }
                default -> System.out.println("❌ Option invalide, réessayez.");
            }
        }
    }

    private void showMenu() {
        System.out.println("""
                ----📝 GESTION DE INGREDIENTS ----
               1️⃣ Afficher tous les ingredients
               2️⃣ Creer un ingredient
               3️⃣ Mettre à jour un ingredient
               4️⃣ Supprimer un ingredient
               q️⃣  Quitter gestion des ingredients
                """);
    }

    private void createIngredient() {
        System.out.println("--- ajouter un ingredient ---");
        System.out.println("nom :");
        String name = scanner.nextLine();

        // Création de l'ingrédient
        Ingredient ingredient = Ingredient.builder().name(name).build();

        // Appel de la méthode save de l'instance ingredientDAO
        Ingredient savedIngredient = ingredientDAO.save(ingredient);
        if (savedIngredient != null) {
            System.out.println("✅ L'ingredient"+savedIngredient.getName()+" a été ajouté avec succès");
        } else {
            System.out.println("❌ Erreur lors de l'ajout de l'ingredient.");
        }
    }

    private void showIngredients() {
        List<Ingredient> ingredients = ingredientDAO.getAll();
        if (ingredients.isEmpty()) {
            System.out.println("🚫 Aucun ingrédient trouvé.");
        } else {
            System.out.println("🍽 Liste des ingrédients : ");
            ingredients.forEach(ingredient ->
                    System.out.println(ingredient.getId() + ". " + ingredient.getName())
            );
        }
    }

    private void updateIngredient() {
        System.out.println("--- Mettre à jour un ingredient ---");
        System.out.print("Entrez l'ID de l'ingrédient à mettre à jour : ");
        int id = Integer.parseInt(scanner.nextLine());

        Ingredient ingredient = ingredientDAO.getById(id);
        if (ingredient != null) {
            System.out.print("Nom actuel : " + ingredient.getName() + "\nNouveau nom : ");
            String newName = scanner.nextLine();
            ingredient.setName(newName);

            boolean updated = ingredientDAO.update(ingredient);
            if (updated) {
                System.out.println("✅ L'ingrédient a été mis à jour avec succès.");
            } else {
                System.out.println("❌ Erreur lors de la mise à jour de l'ingrédient.");
            }
        } else {
            System.out.println("❌ Ingrédient non trouvé.");
        }
    }

    private void deleteIngredient() {
        System.out.println("--- Supprimer un ingredient ---");
        System.out.print("Entrez l'ID de l'ingrédient à supprimer : ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deleted = ingredientDAO.delete(id);
        if (deleted) {
            System.out.println("✅ L'ingrédient a été supprimé avec succès.");
        } else {
            System.out.println("❌ Erreur lors de la suppression de l'ingrédient.");
        }
    }
}
