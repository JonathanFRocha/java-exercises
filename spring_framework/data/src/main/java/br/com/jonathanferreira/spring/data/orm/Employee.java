package br.com.jonathanferreira.spring.data.orm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String document;
    private BigDecimal salary;
    @Column(name = "admission_date")
    private LocalDate admissionDate = LocalDate.now();
    @JoinColumn(name = "job_id")
    @ManyToOne
    private Job job;

    @ManyToMany
    private List<WorkPlace> workPlaces = new ArrayList<>();

    public Employee() {
    }

    public Employee(Integer id, String name, String document, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.salary = salary;
    }

    public Employee(String name, String document, BigDecimal salary) {
        this.name = name;
        this.document = document;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
}
