package org.example;


import org.example.Demo.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Root";

        try(Connection connection = DriverManager.getConnection(url,username,password)){


            if(connection != null) {
                System.out.println("Vous etes connecté");


//            Statement statement = connection.createStatement();
//            String request = "INSERT INTO book (title,author,publisher,isbn) VALUES ('drop database','auteur','publisher','12315648415')";
//            int row = statement.executeUpdate(request);
//            if(row>0){
//                System.out.println("Le livre a ete ajouté");
//            }

                Book book = Book.builder().title("mon livre 2").author("l'author").publisher("publisher").isbn("12561861616").build();

                String request = "INSERT INTO book (title,author,publisher,isbn) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,book.getTitle());
                preparedStatement.setString(2,book.getAuthor());
                preparedStatement.setString(3,book.getPublisher());
                preparedStatement.setString(4,book.getIsbn());
//                preparedStatement.executeUpdate();

//                ResultSet generatedKey = preparedStatement.getGeneratedKeys();
//
//                if(generatedKey.next()){
//                    book.setId(generatedKey.getInt(1));
//                }

//                String requestSelect ="delete FROM book where id = ?";
                String requestSelect ="SELECT * FROM book where id = ?";
                PreparedStatement statement = connection.prepareStatement(requestSelect);
//                statement.setInt(1,3);
//
//                statement.executeUpdate();

                 ResultSet resultSet = statement.executeQuery();

                List<Book> books = new ArrayList<>();

                while(resultSet.next()){
                    books.add(new Book(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("publisher"),
                            resultSet.getString("isbn")
                    ));
                }

                System.out.println(books);
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }
}