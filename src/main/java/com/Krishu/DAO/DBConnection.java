package com.Krishu.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    static final String url="jdbc:mysql://localhost:3306/PracticeProjectWithJDBC";
    static final String name="Krishu";
    static final String password="K&vR39gLow";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,password);
    }

    public static void closeConnection(Connection connection, Statement statement) throws SQLException {
        connection.close();
        statement.close();
    }
}
