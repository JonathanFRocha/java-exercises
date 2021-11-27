package br.com.jonathanferreira.store.tests;

import br.com.jonathanferreira.store.dao.CategoryDAO;
import br.com.jonathanferreira.store.dao.ProductDAO;
import br.com.jonathanferreira.store.model.Category;
import br.com.jonathanferreira.store.model.Product;
import br.com.jonathanferreira.store.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class AddNewProduct {
    public static void main(String[] args) {
        var category = new Category("Cellphones");
        var cellphone = new Product("Xiami Redmi", "Good Cellphone", new BigDecimal("800"), category);
        var meme = new Product("meme", "phone", new BigDecimal("400"), category);
        var bobi = new Product("Bobi", "Good", new BigDecimal("200"), category);

        EntityManager em = JPAUtil.getEntityManager();

        ProductDAO productDAO = new ProductDAO(em);
        CategoryDAO categoryDAO = new CategoryDAO(em);

        em.getTransaction().begin();
        categoryDAO.save(category);
        productDAO.save(cellphone);
        productDAO.save(meme);
        productDAO.save(bobi);
        em.getTransaction().commit();

        Product p = productDAO.findById(1);
        System.out.println(p);

        List<Product> products = productDAO.findAll();
        System.out.println(products);
        em.close();
    }
}
