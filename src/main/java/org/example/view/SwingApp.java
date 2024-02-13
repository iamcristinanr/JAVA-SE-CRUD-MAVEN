/*package org.example.view;


import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
public class SwingApp extends JFrame {

    private final Repository<Employee> employeeRepository;
    private final JTable employeeTable;

    public SwingApp() {
        // Configure the window
        setTitle("Gestión de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 230);

        // Table to show employees
        employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons for actions
        JButton agregarButton = new JButton("Agregar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton eliminarButton = new JButton("Eliminar");

        // Configure the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(actualizarButton);
        buttonPanel.add(eliminarButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Buttons styles
        agregarButton.setBackground(new Color(46, 204, 113));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setFocusPainted(false);

        actualizarButton.setBackground(new Color(52, 152, 219));
        actualizarButton.setForeground(Color.WHITE);
        actualizarButton.setFocusPainted(false);

        eliminarButton.setBackground(new Color(231, 76, 60));
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setFocusPainted(false);

        // Create object repository to access to the ddbb
        employeeRepository = new EmployeeRepository();

        // Load initial employees
        refreshEmployeeTable();

        // Add ActionListener to the buttons
        agregarButton.addActionListener(e -> {
            try {
                agregarEmpleado();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        actualizarButton.addActionListener(e -> actualizarEmpleado());

        eliminarButton.addActionListener(e -> eliminarEmpleado());
    }

    private void refreshEmployeeTable() {
        // Get update list of employees from ddbb
        try {
            List<Employee> employees = employeeRepository.findAll();

            // Create a model of table and set employee data.
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");


            for (Employee employee : employees) {
                Object[] rowData = {
                        employee.getId(),
                        employee.getFirst_name(),

                };
                model.addRow(rowData);
            }

            //  Set a model of table updated
            employeeTable.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los empleados de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarEmpleado() throws SQLException {
        // Create a form to add a employee
        JTextField nombreField = new JTextField();


        Object[] fields = {
                "Nombre:", nombreField,

        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Agregar Empleado", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            //  Create a new object Employee with data added
            Employee employee = new Employee();
            employee.setFirst_name(nombreField.getText());

            // Guardar el nuevo empleado en la base de datos
            employeeRepository.save(employee);

            // Actualizar la tabla con los empleados actualizados
            refreshEmployeeTable();

            JOptionPane.showMessageDialog(this, "Empleado agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void actualizarEmpleado() {
        // Get id employee we want to update
        String empleadoIdStr = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a actualizar:", "Actualizar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (empleadoIdStr != null) {
            try {
                int empleadoId = Integer.parseInt(empleadoIdStr);

                //Get employee from ddbb
                Employee empleado = employeeRepository.getById(empleadoId);

                if (empleado != null) {
                    // Crear un formulario con los datos del empleado
                    JTextField nombreField = new JTextField(empleado.getFirst_name());


                    Object[] fields = {
                            "Nombre:", nombreField,

                    };

                    int confirmResult = JOptionPane.showConfirmDialog(this, fields, "Actualizar Empleado", JOptionPane.OK_CANCEL_OPTION);
                    if (confirmResult == JOptionPane.OK_OPTION) {
                        // Update the data of employee with value added in the form
                        empleado.setFirst_name(nombreField.getText());


                        // Save the changes in the ddbb
                        employeeRepository.save(empleado);

                        // Update the employee table in the interface
                        refreshEmployeeTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún empleado con el ID especificado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el ID", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener los datos del empleado de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarEmpleado() {
        // Get id employee to delete
        String empleadoIdStr = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a eliminar:", "Eliminar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (empleadoIdStr != null) {
            try {
                int empleadoId = Integer.parseInt(empleadoIdStr);

                // Confirm the elimination
                int confirmResult = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el empleado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    // Eliminar el empleado de la base de datos
                    employeeRepository.delete(empleadoId);

                    // Actualizar la tabla de empleados en la interfaz
                    refreshEmployeeTable();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el ID del empleado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}*/
