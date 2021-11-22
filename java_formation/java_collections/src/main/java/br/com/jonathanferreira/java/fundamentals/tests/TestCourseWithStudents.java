package br.com.jonathanferreira.java.fundamentals.tests;

import br.com.jonathanferreira.java.fundamentals.tests.entities.Course;
import br.com.jonathanferreira.java.fundamentals.tests.entities.Lecture;
import br.com.jonathanferreira.java.fundamentals.tests.entities.Student;

public class TestCourseWithStudents {
    public static void main(String[] args) {
        var javaCollections = new Course("Java Collections", "Paulo");
        javaCollections.add(new Lecture("Testing linkedLists", 30));
        javaCollections.add(new Lecture("Testing tests", 21));
        javaCollections.add(new Lecture("modeling collections arraylist", 18));

        var a1 = new Student("Jonathan Ferreira",1234);
        var a2 = new Student("Guilherme",5678);
        var a3 = new Student("Paim",9012);

        javaCollections.register(a1);
        javaCollections.register(a2);
        javaCollections.register(a3);

        System.out.println("students registered");

        javaCollections.getStudents().forEach(s -> System.out.println(s));

        System.out.println("The student " + a1 + " is registered?");
        System.out.println(javaCollections.isRegistered(a1));

        var a4 = new Student("Jonathan Ferreira",1234);

        System.out.println("The student " + a4 + " is registered?");
        System.out.println(javaCollections.isRegistered(a4));
    }



}
