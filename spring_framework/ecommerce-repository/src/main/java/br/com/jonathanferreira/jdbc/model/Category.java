package br.com.jonathanferreira.jdbc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
    private Integer id;
    private final String name;
    private List<Product> productList = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void add(Product product) {
        this.productList.add(product);
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    @Override
    public String toString() {
        return String.format("Category: id %d, name %s, products: %s", id, name, productList);
    }
}
