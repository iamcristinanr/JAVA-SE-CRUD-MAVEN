package org.example;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/project";
        String user = "root";
        String pass = "";

        //From java 7. Try-with resources.
        // The resources inside the try block are closed at the end, whether or not there is an exception.

        try ( Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStamt = myConn.createStatement();
            ResultSet myRes= myStamt.executeQuery("SELECT * FROM employees ORDER BY first_name");
            ) {
            System.out.println("Great, we are connected");

            while (myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong :(");
        }
        }
}
