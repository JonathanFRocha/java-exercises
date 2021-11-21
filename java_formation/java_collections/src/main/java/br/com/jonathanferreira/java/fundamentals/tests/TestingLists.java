package br.com.jonathanferreira.java.fundamentals.tests;

import java.util.ArrayList;
import java.util.Collections;

public class TestingLists {
    public static void main(String[] args) {
        var class1 = "Learning more about lists";
        var class2 = "modeling classes";
        var class3 = "working with sets and courses";

        var classes = new ArrayList<String>();

        classes.add(class1);
        classes.add(class2);
        classes.add(class3);

        System.out.println(classes);

        classes.remove(0);

        classes.forEach(c -> System.out.println("Class: " + c));

        System.out.println(classes.size());

        Collections.sort(classes);
    }
}
