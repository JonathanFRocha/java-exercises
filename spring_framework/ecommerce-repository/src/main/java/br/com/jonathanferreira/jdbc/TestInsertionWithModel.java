package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.dao.ProductDAO;
import br.com.jonathanferreira.jdbc.model.Product;

import java.sql.*;

public class TestInsertionWithModel {
    public static void main(String[] args) {
        Product product = new Product("pc", "good pc");

        try(Connection con = new ConnectionFactory().getConnection()) {
           new ProductDAO(con).save(product);
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(product);
    }
}
