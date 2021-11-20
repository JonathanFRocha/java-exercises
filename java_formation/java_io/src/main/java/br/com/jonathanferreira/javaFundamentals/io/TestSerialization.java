package br.com.jonathanferreira.javaFundamentals.io;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var name = "Jonathan Ferreira";

/*        var oos = new ObjectOutputStream(new FileOutputStream("object.bin"));
        oos.writeObject(name);
        oos.close();*/


        var ois = new ObjectInputStream(new FileInputStream("object.bin"));
        var obj = (String) ois.readObject();

        System.out.println(obj);
    }
}
