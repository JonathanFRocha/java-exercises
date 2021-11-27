package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.ConnectionFactory;

import java.sql.Connection;

public class TestDelete {

    public static void main(String[] args) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            var stm = conn.createStatement();
            stm.execute("DELETE FROM product WHERE id > 2");

            var modifiedLines = stm.getUpdateCount();
            System.out.println("Lines qty that was modified: " + modifiedLines);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
