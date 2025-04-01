package org.example.ExoDAO.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private final static String URL = "jdbc:mysql://localhost:3306/mybdd";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
