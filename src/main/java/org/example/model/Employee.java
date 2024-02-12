package org.example.model;

public class Employee {

    private Integer id;
    private String first_name;

    public Employee() {
    }

    public Employee(Integer id, String first_name) {
        this.id = id;
        this.first_name = first_name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                '}';
    }
}
