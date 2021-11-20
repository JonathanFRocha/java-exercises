package br.com.jonathanferreira.javaFundamentals.io;

import java.io.*;

public class TestReader {

    public static void main(String[] args) throws FileNotFoundException {
        try(var fos = new FileOutputStream("lorem2.txt")){
            Writer osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("test test test test test test test test test");
            bw.newLine();
            bw.write("abc abc adc abc abc adc abc abc adc");
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
