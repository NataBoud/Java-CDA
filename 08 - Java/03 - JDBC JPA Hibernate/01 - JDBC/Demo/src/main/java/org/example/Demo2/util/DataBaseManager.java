package org.example.Demo2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private final static String url = "jdbc:mysql://localhost:3306/jdbc";
    private final static String username = "root";
    private final static String password = "Root";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url,username,password);
        connection.setAutoCommit(false);
        return connection;
    }
}
