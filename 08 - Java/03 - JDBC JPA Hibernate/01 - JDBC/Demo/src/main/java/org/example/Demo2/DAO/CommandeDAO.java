package org.example.Demo2.DAO;

import org.example.Demo2.Entity.Commande;
import org.example.Demo2.Entity.Plante;
import org.example.Demo2.util.DataBaseManager;

import java.sql.*;

public class CommandeDAO {

    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;
    private PlanteDAO planteDAO;

    public CommandeDAO() {
        planteDAO = new PlanteDAO();
    }

    public Commande save (Commande commande){
        try(Connection connection = DataBaseManager.getConnection()){
            request = "INSERT INTO commandes (prix,quantite,plante_id) VALUES (?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setFloat(1,commande.getPrix());
            statement.setInt(2,commande.getQuantite());
            statement.setInt(3,commande.getPlante().getId());

            int nbrrow = statement.executeUpdate();

            if(nbrrow != 1){
                connection.rollback();
                return null;
            }

            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                commande.setId(resultSet.getInt(1));
            }

            connection.commit();
            return commande;


        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Commande getById (int id){
        try(Connection connection = DataBaseManager.getConnection()){
            request = "SELECT * FROM commandes WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);

            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Commande(
                        resultSet.getInt("id"),
                        resultSet.getFloat("prix"),
                        resultSet.getInt("quantite"),
                        planteDAO.getById(resultSet.getInt("plante_id"))
                );
            }

            return null;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
