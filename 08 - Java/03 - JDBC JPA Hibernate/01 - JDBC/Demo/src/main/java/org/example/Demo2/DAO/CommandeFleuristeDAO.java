package org.example.Demo2.DAO;

import org.example.Demo2.util.DataBaseManager;
import org.example.Demo2.Entity.Commande;
import org.example.Demo2.Entity.CommandeFleuriste;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeFleuristeDAO {
    private Connection connection;
    private PlanteDAO planteDAO;

    public CommandeFleuristeDAO() throws SQLException {
        connection = DataBaseManager.getConnection();
        planteDAO = new PlanteDAO();
    }

    public CommandeFleuriste save (CommandeFleuriste commandeFleuriste) throws SQLException {
        try{
            String request = "INSERT INTO commande_fleuriste (id_commande,id_fleuriste) VALUE (?,?)";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, commandeFleuriste.getCommande().getId());
            statement.setInt(2, commandeFleuriste.getFleuriste().getId());

            int nbrRow = statement.executeUpdate();

            if(nbrRow != 1){
                connection.rollback();
                return null;
            }
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                commandeFleuriste.setId(resultSet.getInt(1));
            }
            connection.commit();
            return commandeFleuriste;


        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;

        }
    }

    public List<Commande> getAllCommandeByFleuristeId (int idFleuriste){
        try{
            List<Commande> commandes = new ArrayList<>();
            String request = "SELECT c.id as commandId, c.prix as commandePrix, c.quantite as commandeQuantite, c.plante_id as commandePlanteId " +
                    "FROM commande as c " +
                    "INNER JOIN commande_fleuriste as f " +
                    "ON f.id_commande = c.id " +
                    "WHERE f.id_fleuriste = ?";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1,idFleuriste);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                commandes.add(Commande.builder().id(resultSet.getInt("id"))
                        .prix(resultSet.getFloat("prix"))
                        .quantite(resultSet.getInt("quantite"))
                        .plante(planteDAO.getById(resultSet.getInt("plante_id"))).build());
            }

            return commandes;

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
