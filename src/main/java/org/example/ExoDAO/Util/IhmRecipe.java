package org.example.ExoDAO.Util;

import org.example.ExoDAO.DAO.IngredientDAO;
import org.example.ExoDAO.DAO.RecipeDAO;
import org.example.ExoDAO.DAO.RecipeIngredientDAO;
import org.example.ExoDAO.Entity.Categorie;
import org.example.ExoDAO.Entity.Ingredient;
import org.example.ExoDAO.Entity.Recipe;
import org.example.ExoDAO.Entity.RecipeIngredient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IhmRecipe {
    private Scanner scanner;
    private RecipeDAO recipeDAO;
    private RecipeIngredientDAO recipeIngredientDAO;

    public IhmRecipe() {
        scanner = new Scanner(System.in);
        try {
            recipeDAO = new RecipeDAO();
            recipeIngredientDAO = new RecipeIngredientDAO();
        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de la connexion à la base de données : " + e.getMessage());
        }

    }

    public void start() throws SQLException {
        String entry ;
        while (true){
            showMenu();
            entry = scanner.nextLine();
            switch (entry) {
                case "1" -> showRecipes();
                case "2" -> createRecipe();
                case "3" -> updateRecipe();
                case "4" -> deleteRecipe();
                case "q" -> {
                    return;
                }
                default -> System.out.println("❌ Option invalide, réessayez.");
            }
        }
    }
    private void showMenu() {
        System.out.println("""
                ----📝 GESTION DES RECETTES ----
               1️⃣ Afficher tous les recettes
               2️⃣ Creer une recette
               3️⃣ Mettre à jour une recette
               4️⃣ Supprimer une recette
               q️⃣  Quitter gestion des recettes
                """);
    }

    private void createRecipe() {
        System.out.println("--- Création d'une nouvelle recette ---");

        System.out.print("Nom de la recette : ");
        String name = scanner.nextLine();

        System.out.print("Temps de préparation (en minutes) : ");
        int prepTime = Integer.parseInt(scanner.nextLine());

        System.out.print("Temps de cuisson (en minutes) : ");
        int cookTime = Integer.parseInt(scanner.nextLine());

        System.out.print("Difficulté (Facile / Moyenne / Difficile) : ");
        String difficulty = scanner.nextLine();

        System.out.print("ID de la catégorie : ");
        int categoryId = Integer.parseInt(scanner.nextLine());

        // Création de la catégorie associée (à récupérer via un DAO si nécessaire)
        Categorie category = new Categorie(categoryId, null);

        // Saisie des ingrédients
        List<Ingredient> ingredients = new ArrayList<>();
        while (true) {
            System.out.print("Ajouter un ingrédient ? (oui/non) : ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("oui")) {
                break;
            }

            System.out.print("ID de l'ingrédient : ");
            String ingredientInput = scanner.nextLine().trim();

            try {
                int ingredientId = Integer.parseInt(ingredientInput);
                ingredients.add(new Ingredient(ingredientId, null));
            } catch (NumberFormatException e) {
                System.out.println("❌ Erreur : L'ID de l'ingrédient doit être un nombre valide.");
            }
        }

        // Création de l'objet Recipe
        Recipe recipe = Recipe.builder()
                .name(name)
                .prepTime(prepTime)
                .cookTime(cookTime)
                .difficulty(difficulty)
                .category(category)
                .ingredients(ingredients)
                .build();

        try {
            Recipe savedRecipe = recipeDAO.save(recipe);
            if (savedRecipe != null) {
                System.out.println("✅ Recette créée avec succès : " + savedRecipe.getName());

                // Ajouter les ingrédients dans la table pivot
                for (Ingredient ingredient : recipe.getIngredients()) {
                    RecipeIngredient recipeIngredient = RecipeIngredient.builder()
                            .recipe(recipe)
                            .ingredient(ingredient)
                            .build();
                    recipeIngredientDAO.save(recipeIngredient);
                }
            } else {
                System.out.println("❌ Erreur lors de la création de la recette.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private void showRecipes() throws SQLException {
        List<Recipe> recipes = recipeDAO.getAll();
        if (recipes.isEmpty()) {
            System.out.println("🚫 Aucune categorie trouvée.");
        } else {
            System.out.println("🍽 Liste de recettes : ");
            recipes.forEach(recipe ->
                    System.out.println(recipe.getId() + ". " + recipe.getName())
            );
        }
    }

    private void updateRecipe() throws SQLException {
        System.out.println("--- Mettre à jour une recette ---");
        System.out.print("Entrez l'ID de l'ingrédient à mettre à jour : ");
        int id = Integer.parseInt(scanner.nextLine());

        Recipe recipe = recipeDAO.getById(id);

        if (recipe != null) {
            System.out.print("Nom actuel : " + recipe.getName() + "\nNouveau nom : ");
            String newName = scanner.nextLine();
            recipe.setName(newName);
        }
    }

    private void deleteRecipe() {}
}

