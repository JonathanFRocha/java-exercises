package br.com.jonathanferreira.javafundamentals.unitTest.tdd.service;

import br.com.jonathanferreira.javafundamentals.unitTest.tdd.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    public BigDecimal calculateBonus (Employee employee) {
        var value = employee.getSalary().multiply(new BigDecimal("0.1"));
        if(value.compareTo(new BigDecimal("1000"))> 0) {
            throw new IllegalArgumentException("Employee salary above 1000.00");
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}
