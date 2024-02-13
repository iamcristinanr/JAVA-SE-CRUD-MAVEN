package org.example.main;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DatabaseConnection;
//import org.example.view.SwingApp;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Lanzar la visual
        /*SwingApp app = new SwingApp();
        app.setVisible(true);*/

        try(Connection myConn = DatabaseConnection.getInstance()){

            if(myConn.getAutoCommit()){
                myConn.setAutoCommit((false));
            }

            try{
                Repository<Employee> repository = new EmployeeRepository(myConn);

                System.out.println("Insertar un nuevo empleado");
                Employee employee = new Employee();
                employee.setFirst_name("America");
                employee.setId(5);
                employee.setDNI(123456789);
                repository.save(employee);
                myConn.commit();
            } catch (SQLException e){
                myConn.rollback();
                throw new RuntimeException(e);
            }

        }


    }
}

/*import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DatabaseConnection;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  throws SQLException {

       /* System.out.println("---Listando todos----");
        Repository<Employee> repository = new EmployeeRepository();
        repository.findAll().forEach(System.out::println);

        System.out.println("----Buscando por ID----");
        System.out.println(repository.getById(1));


        //From java 7. Try-with resources.
        // The resources inside the try block are closed at the end, whether or not there is an exception.

        try ( Connection myConn = DatabaseConnection.getInstance()){
              Repository<Employee> repository = new EmployeeRepository();

              System.out.println("---Listando todos----");
              repository.findAll().forEach(System.out::println);

              System.out.println("---Listando el empleado id 1----");
              System.out.println(repository.getById(1));

              System.out.println("---Actualizando empleado----");
              Employee employee = new Employee();

              //All attributes to update
              employee.setFirst_name("Diego");
              employee.setId(1);
              repository.save(employee);

              System.out.println("---Empleado actualizado---");
              repository.findAll().forEach(System.out::println);

              System.out.println("---Empleado eliminado---");
              repository.delete(1);
              repository.findAll().forEach(System.out::println);


        }

    }
}*/
