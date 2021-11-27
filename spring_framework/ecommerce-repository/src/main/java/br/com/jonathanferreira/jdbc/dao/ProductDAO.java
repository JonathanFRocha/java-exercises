package br.com.jonathanferreira.jdbc.dao;

import br.com.jonathanferreira.jdbc.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Product product) {

        String sql = "INSERT INTO product (name, description) VALUES ( ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, product.getName());
            pstm.setString(2, product.getDescription());
            pstm.execute();
            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    product.setId(rst.getInt(1));
                }
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        System.out.println(product);
    }

    public List<Product> list(){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            var rst = pstm.getResultSet();
            while(rst.next()){
                Integer id = rst.getInt("id");
                String name = rst.getString("name");
                String description = rst.getString("description");
                productList.add(new Product(id, name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
