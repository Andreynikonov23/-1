package ru.sapteh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL= "jdbc:mysql://localhost:3306/exam?serverTimezone=UTC";
    public static final String LOGIN= "root";
    public static final String PASSWORD= "1234";

    public Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    public void closeConnection (Connection connection) throws SQLException {
        if (connection==null) return;
        connection.close();
    }
}
