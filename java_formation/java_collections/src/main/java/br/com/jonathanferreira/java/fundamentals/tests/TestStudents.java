package br.com.jonathanferreira.java.fundamentals.tests;

import java.util.HashSet;
import java.util.Set;

public class TestStudents {
    public static void main(String[] args) {
        Set<String> students = new HashSet<>();

        students.add("Jonathan Ferreira");
        students.add("Roberto Ferreira");
        students.add("Albu Ferreira");
        students.add("Sergio Lopes");
        students.add("Mauricio Aniche");
        students.add("Alberto Sousa");

        for(String a:students){
            System.out.println(a);
        }

        students.forEach(a -> System.out.println(a));

        System.out.println(students);
    }
}
