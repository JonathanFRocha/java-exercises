package br.com.jonathanferreira.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertionWithParams {
    public static void main(String[] args) {

        try (Connection conn = new ConnectionFactory().getConnection()) {
            conn.setAutoCommit(false);
            try{
                String sql = "INSERT INTO product (name, description) VALUES ( ?, ?)";
                var pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                addVariablesAndExecute("smart tv", "super smart", pstm);
                addVariablesAndExecute("xbox 360", "game", pstm);
                conn.commit();
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("executing rollback");
                conn.rollback();
            }

        } catch (SQLException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addVariablesAndExecute(String name, String descriptions, PreparedStatement pstm) throws SQLException {
        pstm.setString(1, name);
        pstm.setString(2, descriptions);

        if(name.equals("xbox 360")) throw new RuntimeException("Forbidden Product");

        pstm.execute();

        var rst = pstm.getGeneratedKeys();
        while (rst.next()) {
            int id = rst.getInt(1);
            System.out.println("item inserted has id: " + id);
        }
    }
}
