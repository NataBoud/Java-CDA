package org.example.Demo2.DAO;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;
import org.example.Demo2.Entity.Plante;
import org.example.Demo2.util.DataBaseManager;

import java.sql.*;

public class PlanteDAO {

    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public Plante save (Plante plante){
        try(Connection connection = DataBaseManager.getConnection()){
            request = "INSERT INTO plantes (name,age,color) VALUES (?,?,?)";
            statement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,plante.getName());
            statement.setInt(2,plante.getAge());
            statement.setString(3,plante.getColor());

            int nbrrow = statement.executeUpdate();

            if(nbrrow != 1){
                connection.rollback();
                return null;
            }

            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                plante.setId(resultSet.getInt(1));
            }

            connection.commit();
            return plante;


        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Plante getById (int id){
        try(Connection connection = DataBaseManager.getConnection()){
            request = "SELECT * FROM plantes WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);

            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Plante(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("color")
                );
            }

            return null;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
