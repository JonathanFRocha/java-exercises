package br.com.jonathanferreira.fundamentals.javaUtils;

import java.util.ArrayList;
import java.util.List;

public class TestIntegerWrapper {
   // Wrappers
    public static void main(String[] args) {
        int[] ages = new int[5];

        var ageRef = Integer.valueOf(29); // autoboxing
        var value = ageRef.intValue(); // unboxing

        var numbers = new ArrayList<Integer>();
        int age = 29;

        String s = args[0];

        //Integer number = Integer.valueOf(s);
        var number = Integer.parseInt(s);

        System.out.println(number);

        numbers.add(age);

    }
}
