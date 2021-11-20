package br.com.jonathanferreira.fundamentals.javaUtils;

import java.sql.Array;

public class TestArrayPrimitives {
    public static void main(String[] args) {
        int[] idades = new int[5];
        for (int i = 0; i < idades.length; i++) {
                idades[i] = i*i;
            System.out.println(idades[i]);
        }
    }
}
