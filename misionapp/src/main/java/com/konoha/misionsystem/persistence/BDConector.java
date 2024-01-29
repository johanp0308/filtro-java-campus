package com.konoha.misionsystem.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConector {
    private static String url = "";
    private static String user = "";
    private static String password = "";
    private static Connection con = null;

    public static Connection MySQLConnection() throws SQLException{
        url = "jdbc:mysql://localhost:3306/db_konohamision";
        user = "root";
        password = "pajar_google24";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    
}
