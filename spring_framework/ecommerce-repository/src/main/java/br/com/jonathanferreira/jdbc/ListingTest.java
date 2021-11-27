package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.configreader.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ListingTest {

    public static void main(String[] args) throws IllegalAccessException {

        try (Connection conn = new ConnectionFactory().getConnection()){
            var sql = "SELECT * FROM product";
            var pstm = conn.prepareStatement(sql);
            pstm.execute();

            var rst = pstm.getResultSet();
            while(rst.next()){
                Integer id = rst.getInt("id");
                String name = rst.getString("name");
                String description = rst.getString("description");

                System.out.println(id);
                System.out.println(name);
                System.out.println(description);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
