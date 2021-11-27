package br.com.jonathanferreira.jdbc.model;

public class Product {
    private Integer id;
    private String name;
    private String description;

    public Product() {
    }

    public Product(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Product is %d, %s, %s", id, name, description);
    }
}
