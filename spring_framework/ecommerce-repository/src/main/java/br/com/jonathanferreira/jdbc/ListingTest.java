package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.configreader.PropertyReader;
import br.com.jonathanferreira.jdbc.dao.ProductDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ListingTest {

    public static void main(String[] args) throws IllegalAccessException {

        try (Connection conn = new ConnectionFactory().getConnection()) {
            var productList = new ProductDAO(conn).list();
            System.out.println(productList);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
