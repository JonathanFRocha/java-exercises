package br.com.jonathanferreira.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class TestInsertion {
    public static void main(String[] args) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            var stm = conn.createStatement();
            stm.execute("INSERT INTO product (name, description) VALUES ('mouse', 'mouse sem fio')",
                    Statement.RETURN_GENERATED_KEYS);

            var rst = stm.getGeneratedKeys();
            while (rst.next()) {
                int id = rst.getInt(1);
                System.out.println("item inserted has id: " + id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
