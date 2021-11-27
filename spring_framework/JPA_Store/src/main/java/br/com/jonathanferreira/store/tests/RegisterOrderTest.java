package br.com.jonathanferreira.store.tests;

import br.com.jonathanferreira.store.dao.CategoryDAO;
import br.com.jonathanferreira.store.dao.ClientDAO;
import br.com.jonathanferreira.store.dao.OrderDAO;
import br.com.jonathanferreira.store.dao.ProductDAO;
import br.com.jonathanferreira.store.model.*;
import br.com.jonathanferreira.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RegisterOrderTest {
    public static void main(String[] args) {
        populateDB();


        EntityManager em = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(em);
        ClientDAO clientDAO = new ClientDAO(em);

        var product = productDAO.findById(1);
        var client = clientDAO.findById(1);

        em.getTransaction().begin();

        Order order =  new Order(client);
        order.addItem(new OrderItems(10, product, order));

        OrderDAO orderDAO = new OrderDAO(em);
        orderDAO.save(order);

        em.getTransaction().commit();
        em.close();
    }

    private static void populateDB(){
        var category = new Category("Cellphones");
        var cellphone = new Product("Xiami Redmi", "Good Cellphone", new BigDecimal("800"), category);
        var meme = new Product("meme", "phone", new BigDecimal("400"), category);
        var bobi = new Product("Bobi", "Good", new BigDecimal("200"), category);
        var client = new Client("Jonathan", "1234567");

        EntityManager em = JPAUtil.getEntityManager();

        ProductDAO productDAO = new ProductDAO(em);
        CategoryDAO categoryDAO = new CategoryDAO(em);
        ClientDAO clientDAO = new ClientDAO(em);

        em.getTransaction().begin();
        categoryDAO.save(category);
        productDAO.save(cellphone);
        productDAO.save(meme);
        productDAO.save(bobi);
        clientDAO.save(client);
        em.getTransaction().commit();

        Product p = productDAO.findById(1);
        System.out.println(p);

        List<Product> products = productDAO.findAll();
        System.out.println(products);
        em.close();
    }
}
