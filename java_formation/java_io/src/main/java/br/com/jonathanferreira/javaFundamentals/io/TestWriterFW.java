package br.com.jonathanferreira.javaFundamentals.io;

import java.io.*;

public class TestWriterFW {

    public static void main(String[] args) throws FileNotFoundException {
        try(FileWriter fw = new FileWriter("lorem2.txt")){
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("test test test test test test test test test");
            bw.newLine();
            bw.write("abc abc adc abc abc adc abc abc adc");
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
