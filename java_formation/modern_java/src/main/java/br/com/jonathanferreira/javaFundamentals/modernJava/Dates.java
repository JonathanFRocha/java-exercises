package br.com.jonathanferreira.javaFundamentals.modernJava;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println(today);

        var olimpicsDate = LocalDate.of(2022, Month.AUGUST, 5);
        int years = olimpicsDate.getYear() - today.getYear();
        System.out.println(years);

        Period period = Period.between(today, olimpicsDate);
        System.out.println(period);

        var yearsTest = olimpicsDate.plusYears(4);
        System.out.println(yearsTest);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(olimpicsDate.format(formatter));

    }
}
