package br.com.jonathanferreira.java.fundamentals.tests;

import br.com.jonathanferreira.java.fundamentals.tests.entities.Course;
import br.com.jonathanferreira.java.fundamentals.tests.entities.Lecture;

public class TestCourse {

    public static void main(String[] args) {
        var c1 = new Course("Java Collections", "Paulo");
        c1.add(new Lecture("Testing linkedLists", 30));
        c1.add(new Lecture("Testing tests", 21));
        c1.add(new Lecture("modeling collections arraylist", 18));
        var lectures = c1.getLectures();


        System.out.println(lectures);
    }
}
