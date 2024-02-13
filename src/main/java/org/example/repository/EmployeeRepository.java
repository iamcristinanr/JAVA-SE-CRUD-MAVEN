package org.example.repository;

import org.example.model.Employee;
import org.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee>{

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try(Statement myStamt = getConnection().createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees")){
            while(myRes.next()){
                Employee e = createEmployee(myRes);
                employees.add(e);

            }
        }

        return employees;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try(PreparedStatement myStamt = getConnection().prepareStatement("SELECT * FROM employees WHERE id = ?")){
            myStamt.setInt(1,id);
            try(ResultSet myRes = myStamt.executeQuery()){
                if(myRes.next()){
                    employee = createEmployee(myRes);
                }
            }
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        String sql;
        // If id>0, then exist id so update, else insert
        if(employee.getId()!= null && employee.getId()>0) {
            sql = "UPDATE employees SET first_name =? WHERE id=?";
        }else {
            sql = "INSERT INTO employees(first_name) VALUES(?)";
        }
        try(PreparedStatement myStamt = getConnection().prepareStatement(sql)){
            //all columms
            myStamt.setString(1, employee.getFirst_name());
            if(employee.getId() != null && employee.getId()>0) {
                myStamt.setInt(2, employee.getId());
            }
            myStamt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(PreparedStatement myStamt = getConnection().prepareStatement("DELETE FROM employees WHERE id=?")){
            myStamt.setInt(1,id);
            myStamt.executeUpdate();
        }
    }

    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));

        return e;
    }
}
