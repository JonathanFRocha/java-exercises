package br.com.jonathanferreira.fundamentals.javaUtils;

public class TestWrappers {

    public static void main(String[] args) {
        var ageRef = Integer.valueOf(29); // autoboxing
        var value = ageRef.intValue(); // unboxing

        var dref = Double.valueOf(3.2);
        System.out.println(dref.doubleValue());

        var bRef = Boolean.TRUE;
        System.out.println(bRef.booleanValue());

        Number refNumber = Double.valueOf(29.9);
        refNumber.intValue();
    }
}
