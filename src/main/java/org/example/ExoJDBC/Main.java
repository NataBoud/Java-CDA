package org.example.ExoJDBC;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mybdd";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (connection != null) {
                System.out.println("Vous êtes connecté à la base de données.");
                IHM.afficherMenu(connection); // Appel à la méthode du menu
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
        }
    }
}
