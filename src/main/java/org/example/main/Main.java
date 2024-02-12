package org.example.main;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DatabaseConnection;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  throws SQLException {


        //From java 7. Try-with resources.
        // The resources inside the try block are closed at the end, whether or not there is an exception.

        try ( Connection myConn = DatabaseConnection.getInstance()){
              Repository<Employee> repository = new EmployeeRepository();

              repository.findAll().forEach(System.out::println);

        }

    }
}
