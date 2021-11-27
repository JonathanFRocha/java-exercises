package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.ConnectionFactory;

import java.sql.Connection;

public class TestDelete {

    public static void main(String[] args) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            var idToDelete = 2;
            var sql = "DELETE FROM product WHERE id > ?";
            var pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idToDelete);

            pstm.execute();

            var modifiedLines = pstm.getUpdateCount();
            System.out.println("Lines qty that was modified: " + modifiedLines);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
