package com.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    //singleton
    private static DbConnection dbConnection; //instance
    private  Connection connection; //instance

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ead_pos",
                "root",
                "12345678"
        );
    }
    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        return dbConnection==null?(dbConnection=new DbConnection()):dbConnection;
    }
    public Connection getConnection() {
        return connection;
    }

}
