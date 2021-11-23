package br.com.jonathanferreira.javafundamentals.unitTest.tdd.service;

import br.com.jonathanferreira.javafundamentals.unitTest.tdd.model.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {
    private final BonusService bonus = new BonusService();

    @Test
    public void bonusShouldBeZeroForHighSalary() {


        assertThrows(
                IllegalArgumentException.class,
                () -> bonus.calculateBonus(new Employee("Jonathan", LocalDate.now(), new BigDecimal(10001)))
        );
    }

    @Test
    public void bonusShouldBeTenPercentOfSalary() {
        var value = bonus.calculateBonus(new Employee("Jonathan", LocalDate.now(), new BigDecimal(10000)));
        assertEquals(value, new BigDecimal("1000.00"));
    }

    @Test
    public void bonusShouldBeTenPercentOfSalaryIfBelow1000() {
        var value = bonus.calculateBonus(new Employee("Jonathan", LocalDate.now(), new BigDecimal(5000)));
        assertEquals(value, new BigDecimal("500.00"));
    }
}
