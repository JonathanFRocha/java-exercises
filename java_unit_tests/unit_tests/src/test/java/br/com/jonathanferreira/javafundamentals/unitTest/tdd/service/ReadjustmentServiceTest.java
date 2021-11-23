package br.com.jonathanferreira.javafundamentals.unitTest.tdd.service;

import br.com.jonathanferreira.javafundamentals.unitTest.tdd.model.Employee;
import br.com.jonathanferreira.javafundamentals.unitTest.tdd.model.Perfomance;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReadjustmentServiceTest {

    private final ReadjustmentService service = new ReadjustmentService();
    private Employee employee = new Employee("Jonathan", LocalDate.now(), new BigDecimal("1000.00"));
    @AfterEach
    public void resetEmployee() {
        employee = new Employee("Jonathan", LocalDate.now(), new BigDecimal("1000.00"));
    }
    @Test
    public void ReadjustmentShouldBe3PercentWhenPerformanceIsBad(){
        service.doReadjustment(employee, Perfomance.BAD);
        assertEquals(employee.getSalary(), new BigDecimal("1030.00"));
    }

    @Test
    public void ReadjustmentShouldBe15PercentWhenPerformanceIsOk(){
        service.doReadjustment(employee, Perfomance.OK);
        assertEquals(employee.getSalary(), new BigDecimal("1150.00"));
    }

    @Test
    public void ReadjustmentShouldBe20PercentWhenPerformanceIsGreat(){
        service.doReadjustment(employee, Perfomance.GREAT);
        assertEquals(employee.getSalary(), new BigDecimal("1200.00"));
    }
}
