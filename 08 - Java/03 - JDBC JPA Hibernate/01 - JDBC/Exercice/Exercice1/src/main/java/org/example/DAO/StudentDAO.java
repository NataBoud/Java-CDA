package org.example.DAO;

import org.example.entity.Student;
import org.example.util.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public Student addStudent (Student student){
        try(Connection connection = DataBaseManager.getConnection()){
            request = "INSERT INTO student (firstname,lastname,class_number,diplome_date) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,student.getFirstname());
            statement.setString(2,student.getLastname());
            statement.setInt(3,student.getClassNumber());
            statement.setDate(4, Date.valueOf(student.getDiplomeDate().toString()));

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                student.setId(resultSet.getInt(1));
            }

            return student;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            try{
              if(!statement.isClosed()){
                  statement.close();
              }
              if(!resultSet.isClosed()){
                  resultSet.close();
              }
              request = null;
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }

        }
    }

    public List<Student> getAllStudent (){
        try(Connection connection = DataBaseManager.getConnection()){
            List<Student> students = new ArrayList<>();

            request = "SELECT * FROM student";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("class_number"),
                        resultSet.getDate("diplome_date").toLocalDate()
                ));
            }

            return students;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return  null;
        }
        finally {
            try{
                if(!statement.isClosed()){
                    statement.close();
                }
                if(!resultSet.isClosed()){
                    resultSet.close();
                }
                request = null;
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }

        }
    }

    public List<Student> getAllStudentByClass (int classNumber){
        try(Connection connection = DataBaseManager.getConnection()){
            List<Student> students = new ArrayList<>();

            request = "SELECT * FROM student where class_number = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,classNumber);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("class_number"),
                        resultSet.getDate("diplome_date").toLocalDate()
                ));
            }

            return students;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return  null;
        }
        finally {
            try{
                if(!statement.isClosed()){
                    statement.close();
                }
                if(!resultSet.isClosed()){
                    resultSet.close();
                }
                request = null;
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }

        }
    }

    public boolean deleteStudent (int id){
        try(Connection connection = DataBaseManager.getConnection()){
            request = "DELETE FROM student WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);

            int row = statement.executeUpdate();

            return row == 1;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            try{
                if(!statement.isClosed()){
                    statement.close();
                }
                request = null;
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }

        }
    }


}
