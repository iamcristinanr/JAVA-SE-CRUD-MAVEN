package org.example.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static String url = "jdbc:mysql://127.0.0.1:3306/project";
    private static String user = "root" ;
    private static String pass = "";

    private static BasicDataSource pool;


    public static BasicDataSource getInstance() throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(pass);

            pool.setInitialSize(3);
            pool.setMinIdle(2);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);

        }
        return pool;
    }

    public static Connection getConnetion() throws SQLException {
        return getInstance().getConnection();

    }
}
