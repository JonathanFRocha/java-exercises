package br.com.jonathanferreira.javaFundamentals.io;

import java.io.*;

public class TestWriting {

    public static void main(String[] args) throws FileNotFoundException {
            try(var fis = new FileInputStream("lorem.txt")){
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                String line = br.readLine();
                while(line != null){
                    System.out.println(line);
                    line = br.readLine();
                }
                br.close();
            }catch (IOException e){
                System.out.println(e);
            }


    }
}
