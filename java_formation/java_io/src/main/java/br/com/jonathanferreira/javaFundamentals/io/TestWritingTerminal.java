package br.com.jonathanferreira.javaFundamentals.io;

import java.io.*;

public class TestWritingTerminal {

    public static void main(String[] args) {

        try (var fis = System.in) {
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            try (var fos = new FileOutputStream("lorem2.txt")) {
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String line = br.readLine();
                while (line != null && !line.isEmpty()) {
                    bw.write(line);
                    bw.newLine();
                    line = br.readLine();
                }
                bw.close();
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
