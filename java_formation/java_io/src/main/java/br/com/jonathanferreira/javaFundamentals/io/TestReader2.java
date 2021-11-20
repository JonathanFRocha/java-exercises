package br.com.jonathanferreira.javaFundamentals.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TestReader2 {

    public static void main(String[] args) {

        try(var scanner = new Scanner(new File("contas.csv"))){

            while(scanner.hasNextLine()){
                var line = scanner.nextLine();
                //System.out.println(line);
                try(var lineScanner = new Scanner(line)){
                    lineScanner.useLocale(Locale.ENGLISH);
                    lineScanner.useDelimiter(",");

                    String account = lineScanner.next();
                    int agency = lineScanner.nextInt();
                    int number = lineScanner.nextInt();
                    var name = lineScanner.next();
                    double balance = lineScanner.nextDouble();

                    var text = String.format(new Locale("pt", "BR"),"%s, %03d-%04d, %s: R$%.2f", account, agency, number, name, balance);

                    System.out.println(text);
                }
            }

        }catch (IOException e){
            System.out.println(e);
        }


    }
}
