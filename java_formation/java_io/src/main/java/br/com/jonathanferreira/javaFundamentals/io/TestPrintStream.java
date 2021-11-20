package br.com.jonathanferreira.javaFundamentals.io;

import java.io.*;

public class TestPrintStream {

    public static void main(String[] args) throws FileNotFoundException {
        try(var ps = new PrintStream("lorem2.txt")){

            ps.println("test test test test test test test test test");
            ps.println();
            ps.println("abc abc adc abc abc adc abc abc adc");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
