package br.com.jonathanferreira.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class TestInsertionWithParams {
    public static void main(String[] args) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            String name = "mouse'";
            String descriptions = "mouse sem fio): delete from product;";
            String sql = "INSERT INTO product (name, description) VALUES ( ?, ?)";
            var pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, name);
            pstm.setString(2, descriptions);

            pstm.execute();

            var rst = pstm.getGeneratedKeys();
            while (rst.next()) {
                int id = rst.getInt(1);
                System.out.println("item inserted has id: " + id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
