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
            var stm = conn.createStatement();
            stm.execute("SELECT * FROM product");

            var rst = stm.getResultSet();
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
