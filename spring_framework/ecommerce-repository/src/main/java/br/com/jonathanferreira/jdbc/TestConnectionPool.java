package br.com.jonathanferreira.jdbc;

import java.sql.SQLException;

public class TestConnectionPool {
    public static void main(String[] args) throws IllegalAccessException, SQLException {
        ConnectionFactory conn = new ConnectionFactory();
        for (int i = 1; i <= 20; i++) {
            conn.getConnection();
            System.out.println("connection number: " + i);
        }
    }
}
