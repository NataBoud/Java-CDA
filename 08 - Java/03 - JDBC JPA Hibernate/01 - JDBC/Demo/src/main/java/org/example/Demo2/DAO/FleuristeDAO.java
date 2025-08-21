package org.example.Demo2.DAO;

import org.example.Demo2.util.DataBaseManager;
import org.example.Demo2.Entity.Fleuriste;


import java.sql.*;

public class FleuristeDAO {
    private Connection connection;
    private CommandeFleuristeDAO commandeFleuristeDAO;

    public FleuristeDAO() throws SQLException {
        connection = DataBaseManager.getConnection();
        commandeFleuristeDAO = new CommandeFleuristeDAO();
    }

    public Fleuriste save (Fleuriste fleuriste) throws SQLException {
        try{
            String request = "INSERT INTO fleuriste (name) VALUE (?)";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, fleuriste.getName());

            int nbrRow = statement.executeUpdate();

            if(nbrRow != 1){
                connection.rollback();
                return null;
            }
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                fleuriste.setId(resultSet.getInt(1));
            }
            connection.commit();
            return fleuriste;


        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;

        }
    }

    public Fleuriste getById (int id){
        try{
            String request = "SELECT FROM fleuriste WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return Fleuriste.builder().id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .commandes(commandeFleuristeDAO.getAllCommandeByFleuristeId(resultSet.getInt("id")))
                        .build();
            }

            return null;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
