package br.com.jonathanferreira.fundamentals.javalang;

import br.com.jonathanferreira.fundamentals.javalang.mockClass.Mock;

public class ObjectTest {

    public static void main(String[] args) {
        System.out.println("x");
        System.out.println(2);
        System.out.println(true);

        Object mock = new Mock();

        System.out.println(mock);
        printLn(mock);
    }

    public static void printLn(Object something){

    }
}
