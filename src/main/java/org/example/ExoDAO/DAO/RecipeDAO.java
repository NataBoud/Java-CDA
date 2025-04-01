package org.example.ExoDAO.DAO;

import org.example.ExoDAO.Entity.Recipe;
import org.example.ExoDAO.Entity.Ingredient;
import org.example.ExoDAO.Entity.RecipeIngredient;
import org.example.ExoDAO.Util.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    private Connection connection;
    private RecipeIngredientDAO recipeIngredientDAO;
    private IngredientDAO ingredientDAO;

    public RecipeDAO() throws SQLException {
        connection = DataBaseManager.getConnection();
        recipeIngredientDAO = new RecipeIngredientDAO();
        ingredientDAO = new IngredientDAO();
    }

    public Recipe save(Recipe recipe) throws SQLException {
        try {
            // Désactiver le mode auto-commit
            connection.setAutoCommit(false);

            String request = "INSERT INTO recipes (name, prep_time, cook_time, difficulty, category_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, recipe.getName());
            statement.setInt(2, recipe.getPrepTime());
            statement.setInt(3, recipe.getCookTime());
            statement.setString(4, recipe.getDifficulty());
            statement.setInt(5, recipe.getCategory().getId());

            int nbrRow = statement.executeUpdate();
            if (nbrRow != 1) {
                connection.rollback();
                return null;
            }

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                recipe.setId(resultSet.getInt(1));
            }

            connection.commit();
            return recipe;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean update(Recipe recipe) throws SQLException {
        try {
            String request = "UPDATE recipes SET name = ?, prep_time = ?, cook_time = ?, difficulty = ?, category_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setString(1, recipe.getName());
            statement.setInt(2, recipe.getPrepTime());
            statement.setInt(3, recipe.getCookTime());
            statement.setString(4, recipe.getDifficulty());
            statement.setInt(5, recipe.getCategory().getId());
            statement.setInt(6, recipe.getId());

            int nbrRow = statement.executeUpdate();
            if (nbrRow != 1) {
                connection.rollback();
                return false;
            }

            // Supprimer les anciennes relations et ajouter les nouvelles
            recipeIngredientDAO.deleteByRecipeId(recipe.getId());
            for (Ingredient ingredient : recipe.getIngredients()) {
                RecipeIngredient recipeIngredient = RecipeIngredient.builder()
                        .recipe(recipe)
                        .ingredient(ingredient)
                        .build();
                recipeIngredientDAO.save(recipeIngredient);
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return false;
        }
    }

    public boolean delete(int id) throws SQLException {
        try {
            // Supprimer les relations dans la table pivot
            recipeIngredientDAO.deleteByRecipeId(id);

            String request = "DELETE FROM recipes WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, id);

            int nbrRow = statement.executeUpdate();
            if (nbrRow != 1) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return false;
        }
    }

    public Recipe getById(int id) throws SQLException {
        try {
            String request = "SELECT * FROM recipes WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Recipe.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .prepTime(resultSet.getInt("prep_time"))
                        .cookTime(resultSet.getInt("cook_time"))
                        .difficulty(resultSet.getString("difficulty"))
                        .category(null) // Il faut récupérer la catégorie via un DAO (à implémenter)
                        .ingredients(recipeIngredientDAO.getAllIngredientsByRecipeId(id))
                        .build();
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Recipe> getAll() throws SQLException {
        try {
            List<Recipe> recipes = new ArrayList<>();
            String request = "SELECT * FROM recipes";
            PreparedStatement statement = connection.prepareStatement(request);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                recipes.add(Recipe.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .prepTime(resultSet.getInt("prep_time"))
                        .cookTime(resultSet.getInt("cook_time"))
                        .difficulty(resultSet.getString("difficulty"))
                        .category(null) // Il faut récupérer la catégorie via un DAO
                        .ingredients(recipeIngredientDAO.getAllIngredientsByRecipeId(resultSet.getInt("id")))
                        .build());
            }
            return recipes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
