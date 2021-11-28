package br.com.jonathanferreira.spring.data.orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_places")
public class WorkPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String address;
    @ManyToMany(mappedBy = "workPlaces")
    private List<Employee> employees = new ArrayList<>();

    public WorkPlace(Integer id, String description, String address) {
        this.id = id;
        this.description = description;
        this.address = address;
    }

    public WorkPlace(String description, String address) {
        this.description = description;
        this.address = address;
    }

    public WorkPlace() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
