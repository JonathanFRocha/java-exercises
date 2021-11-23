package br.com.jonathanferreira.javafundamentals.unitTest.tdd.service;

import br.com.jonathanferreira.javafundamentals.unitTest.tdd.model.Employee;
import br.com.jonathanferreira.javafundamentals.unitTest.tdd.model.Perfomance;

import java.math.BigDecimal;

public class ReadjustmentService {
    public void doReadjustment(Employee employee, Perfomance perfomance) {
        var newSalary = employee.getSalary().multiply(perfomance.percentReadjustment());
        employee.readjustSalary(newSalary);
    }
}
