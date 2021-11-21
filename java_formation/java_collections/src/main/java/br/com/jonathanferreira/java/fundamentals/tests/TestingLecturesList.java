package br.com.jonathanferreira.java.fundamentals.tests;

import br.com.jonathanferreira.java.fundamentals.tests.entities.Lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestingLecturesList {
    public static void main(String[] args) {
        var a1 = new Lecture("Revisiting Array list", 21);
        var a2 = new Lecture("Objects list", 20);
        var a3 = new Lecture("Relating lists and objects", 15);

        var lectures = new ArrayList<Lecture>();
        lectures.add(a1);
        lectures.add(a2);
        lectures.add(a3);

        System.out.println(lectures);

        Collections.sort(lectures);

        System.out.println(lectures);

        lectures.sort(Comparator.comparing(Lecture::getTime));

        System.out.println(lectures);
    }
}
