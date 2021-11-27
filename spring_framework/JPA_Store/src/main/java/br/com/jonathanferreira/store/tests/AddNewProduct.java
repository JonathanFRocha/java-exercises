package br.com.jonathanferreira.store.tests;

import br.com.jonathanferreira.store.dao.ProductDAO;
import br.com.jonathanferreira.store.model.Product;
import br.com.jonathanferreira.store.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class AddNewProduct {
    public static void main(String[] args) {
        var cellphone = new Product();
        cellphone.setName("Xiami Redmi");
        cellphone.setDescription("Good Cellphone");
        cellphone.setPrice(new BigDecimal("800"));

        EntityManager em = JPAUtil.getEntityManager();

        ProductDAO dao = new ProductDAO(em);

        em.getTransaction().begin();
        dao.save(cellphone);
        em.getTransaction().commit();
        em.close();

    }
}
