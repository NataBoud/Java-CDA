package org.example.ExoDAO.DAO;

import org.example.ExoDAO.Entity.Ingredient;
import org.example.ExoDAO.Entity.Recipe;
import org.example.ExoDAO.Entity.RecipeIngredient;
import org.example.ExoDAO.Util.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientDAO {

    private Connection connection;
    private IngredientDAO ingredientDAO;

    public RecipeIngredientDAO() throws SQLException {
        connection = DataBaseManager.getConnection();
        ingredientDAO = new IngredientDAO();
    }

    public RecipeIngredient save(RecipeIngredient recipeIngredient) throws SQLException {
        try {
            connection.setAutoCommit(false);
            String request = "INSERT INTO recipe_ingredients (recipe_id, ingredient_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, recipeIngredient.getRecipe().getId());
            statement.setInt(2, recipeIngredient.getIngredient().getId());

            int nbrRow = statement.executeUpdate();

            if (nbrRow != 1) {
                connection.rollback();
                return null;
            }

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                recipeIngredient.setId(resultSet.getInt(1));
            }
            connection.commit();
            return recipeIngredient;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }
    }

    public List<Ingredient> getAllIngredientsByRecipeId(int recipeId) {
        try {
            List<Ingredient> ingredients = new ArrayList<>();
            String request = "SELECT i.id as ingredientId, i.name as ingredientName " +
                    "FROM ingredients as i " +
                    "INNER JOIN recipe_ingredients as ri " +
                    "ON ri.ingredient_id = i.id " +
                    "WHERE ri.recipe_id = ?";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, recipeId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ingredients.add(Ingredient.builder().id(resultSet.getInt("ingredientId"))
                        .name(resultSet.getString("ingredientName"))
                        .build());
            }

            return ingredients;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean deleteByRecipeId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean success = false;
        try {
            connection = DataBaseManager.getConnection();
            String request = "DELETE FROM recipe_ingredients WHERE recipe_id = ?";
            statement = connection.prepareStatement(request);

            // Définir le paramètre de la requête (recipe_id)
            statement.setInt(1, id);
            int nbrRowsAffected = statement.executeUpdate();
            if (nbrRowsAffected > 0) {
                success = true;
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression des ingrédients pour la recette ID " + id + ": " + e.getMessage());

            if (connection != null) {
                connection.rollback();
            }
        } finally {
            // Fermer les ressources
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return success;
    }

}
