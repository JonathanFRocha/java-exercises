package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.dao.CategoryDAO;
import br.com.jonathanferreira.jdbc.dao.ProductDAO;
import br.com.jonathanferreira.jdbc.model.Category;
import br.com.jonathanferreira.jdbc.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestCategoryList {
    public static void main(String[] args) {

        try(Connection conn = new ConnectionFactory().getConnection()) {
            CategoryDAO categoryDAO = new CategoryDAO(conn);
            List<Category> listCategories = categoryDAO.listWithProducts();
            listCategories
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
