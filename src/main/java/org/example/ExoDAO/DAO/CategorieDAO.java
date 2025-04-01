package org.example.ExoDAO.DAO;

import org.example.ExoDAO.Entity.Categorie;
import org.example.ExoDAO.Entity.Ingredient;
import org.example.ExoDAO.Util.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO {

    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public Categorie save (Categorie categorie) {
        try(Connection connection = DataBaseManager.getConnection()){

            // Désactivation du mode auto-commit pour permettre le commit manuel
            connection.setAutoCommit(false);

            request = "INSERT INTO categories (name) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,categorie.getName());
            int nbrrow = statement.executeUpdate();
            if(nbrrow != 1){
                connection.rollback();
                return null;
            }
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                categorie.setId(resultSet.getInt(1));
            }
            connection.commit();
            return categorie;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public boolean update(Categorie categorie) {
        try (Connection connection = DataBaseManager.getConnection()) {

            // Désactivation du mode auto-commit pour permettre le commit manuel
            connection.setAutoCommit(false);

            request = "UPDATE categories SET name = ? WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, categorie.getName());
            statement.setInt(2, categorie.getId());
            int nbrrow = statement.executeUpdate();
            connection.commit();
            return nbrrow == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Categorie getById (int id){
        try(Connection connection = DataBaseManager.getConnection()){

            // Désactivation du mode auto-commit pour permettre le commit manuel
            connection.setAutoCommit(false);

            request = "SELECT * FROM categories WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Categorie(
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

            request = "DELETE FROM categories WHERE id = ?";
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

    public List<Categorie> getAll() {
        List<Categorie> categories = new ArrayList<>();
        try (Connection connection = DataBaseManager.getConnection()) {
            request = "SELECT * FROM categories";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Categorie categorie = new Categorie(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                categories.add(categorie);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categories;
    }


}
