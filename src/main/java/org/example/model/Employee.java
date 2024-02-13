package org.example.model;

public class Employee {

    private Integer id;
    private String first_name;

    private Integer DNI;

    public Employee() {
    }

    public Employee(Integer id, String first_name, Integer DNI) {
        this.id = id;
        this.first_name = first_name;
        this.DNI = DNI;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", DNI=" + DNI +
                '}';
    }
}

