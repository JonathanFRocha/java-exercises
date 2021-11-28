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

public class PerfomanceTest {
    public static void main(String[] args) {
        populateDB();
        EntityManager em = JPAUtil.getEntityManager();

        Order order = em.find(Order.class, 1);
        System.out.println(order.getOrderItemsList());
        em.close();
    }

    private static void populateDB(){
        var category = new Category("Cellphones");
        var category2 = new Category("Furniture");
        var category3 = new Category("Home Appliance");
        var cellphone = new Product("Xiami Redmi", "Good Cellphone", new BigDecimal("800"), category);
        var bed = new Product("Bed", "King Sized Bed", new BigDecimal("2150"), category2);
        var refrigerator = new Product("Refrigerator", "Super Freeze Mode", new BigDecimal("999"), category3);
        var client = new Client("Jonathan", "1234567");
        var client2 = new Client("Fernanda", "444232");

        EntityManager em = JPAUtil.getEntityManager();

        ProductDAO productDAO = new ProductDAO(em);
        CategoryDAO categoryDAO = new CategoryDAO(em);
        ClientDAO clientDAO = new ClientDAO(em);
        OrderDAO orderDAO = new OrderDAO(em);



        em.getTransaction().begin();
        categoryDAO.save(category);
        categoryDAO.save(category2);
        categoryDAO.save(category3);
        productDAO.save(cellphone);
        productDAO.save(bed);
        productDAO.save(refrigerator);
        clientDAO.save(client);
        clientDAO.save(client2);

        var cell = productDAO.findById(1);
        var furniture = productDAO.findById(2);
        var homeAppliance = productDAO.findById(3);
        var jonathan = clientDAO.findById(1);
        var fernanda = clientDAO.findById(2);

        Order order1 =  new Order(jonathan);
        Order order2 =  new Order(jonathan);
        Order order3 =  new Order(fernanda);
        Order order4 =  new Order(fernanda);

        order1.addItem(new OrderItems(50, cell, order1));
        order2.addItem(new OrderItems(8, furniture, order2));
        order3.addItem(new OrderItems(2, homeAppliance, order3));
        order4.addItem(new OrderItems(30, cell, order4));

        orderDAO.save(order1);
        orderDAO.save(order2);
        orderDAO.save(order3);
        orderDAO.save(order4);
        em.getTransaction().commit();

        em.close();
    }
}
