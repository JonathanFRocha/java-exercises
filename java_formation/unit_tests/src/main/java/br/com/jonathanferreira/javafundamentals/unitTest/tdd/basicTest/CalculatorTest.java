package br.com.jonathanferreira.javafundamentals.unitTest.tdd.basicTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void shouldSumTwoIntegerNumbers(){
        var c = new Calculator();
        int sum = c.calculate(1, 2);
        Assertions.assertEquals(3 ,sum);
    }
}
