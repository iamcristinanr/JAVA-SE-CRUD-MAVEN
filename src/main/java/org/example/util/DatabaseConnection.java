package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static String url = "jdbc:mysql://127.0.0.1:3306/project";
    private static String user = "root" ;
    private static String pass = "";

    private static Connection myConn;


    public static Connection getInstance() throws SQLException {
        if(myConn == null){
            myConn = DriverManager.getConnection(url,user,pass);
        }
        return myConn;
    }

}