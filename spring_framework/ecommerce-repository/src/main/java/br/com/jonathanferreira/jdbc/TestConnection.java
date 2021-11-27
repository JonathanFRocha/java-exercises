package br.com.jonathanferreira.jdbc;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) throws IllegalAccessException {

        try (Connection conn = new ConnectionFactory().getConnection()){
            System.out.println("Here i'm");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
