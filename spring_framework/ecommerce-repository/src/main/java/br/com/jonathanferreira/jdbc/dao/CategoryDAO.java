package br.com.jonathanferreira.jdbc.dao;

import br.com.jonathanferreira.jdbc.model.Category;
import br.com.jonathanferreira.jdbc.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }


    public List<Category> list() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM category";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
               while(rst.next()){
                   Category category = new Category(rst.getInt(1), rst.getString(2));
                   categoryList.add(category);
               }
            }
        }

        return categoryList;
    }

    public List<Category> listWithProducts() throws SQLException {
        Category last = null;

        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT c.id, c.name, p.id, p.name, p.description FROM category c INNER JOIN"+ " "
                +"product p ON c.id = p.category_id";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
                while(rst.next()){
                    if(last == null || !last.getName().equals(rst.getString(2))){
                        Category category = new Category(rst.getInt(1), rst.getString(2));
                        last = category;
                        categoryList.add(category);
                    }

                    last.add(new Product(rst.getInt(3), rst.getString(4), rst.getString(5)));
                }
            }
        }
        return categoryList;
    }
}
