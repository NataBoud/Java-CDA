package org.example.ExoDAO.DAO;

import org.example.ExoDAO.Entity.Ingredient;
import org.example.ExoDAO.Util.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO {

    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public Ingredient save (Ingredient ingredient){
        try(Connection connection = DataBaseManager.getConnection()){

            // Désactiver le mode auto-commit
            connection.setAutoCommit(false);

            request = "INSERT INTO ingredients (name) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,ingredient.getName());

            int nbrrow = statement.executeUpdate();
            if(nbrrow != 1){
                connection.rollback();
                return null;
            }
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                ingredient.setId(resultSet.getInt(1));
            }
            connection.commit();
            return ingredient;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public boolean update(Ingredient ingredient) {
        try (Connection connection = DataBaseManager.getConnection()) {
            // Désactivation du mode auto-commit pour permettre le commit manuel
            connection.setAutoCommit(false);

            request = "UPDATE ingredients SET name = ? WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, ingredient.getName());
            statement.setInt(2, ingredient.getId());
            int nbrrow = statement.executeUpdate();
            connection.commit();
            return nbrrow == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Ingredient getById (int id){
        try(Connection connection = DataBaseManager.getConnection()){
            request = "SELECT * FROM ingredients WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Ingredient(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
            return null;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean delete(int id) {
        try (Connection connection = DataBaseManager.getConnection()) {
            // Désactivation du mode auto-commit pour permettre le commit manuel
            connection.setAutoCommit(false);

            request = "DELETE FROM ingredients WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            int nbrrow = statement.executeUpdate();
            connection.commit();
            return nbrrow == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<Ingredient> getAll() {
        List<Ingredient> ingredients = new ArrayList<>();
        try (Connection connection = DataBaseManager.getConnection()) {
            request = "SELECT * FROM ingredients";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                ingredients.add(ingredient);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ingredients;
    }


}
