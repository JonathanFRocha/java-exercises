package br.com.jonathanferreira.store.tests;

import br.com.jonathanferreira.store.dao.CategoryDAO;
import br.com.jonathanferreira.store.model.Category;
import br.com.jonathanferreira.store.model.Product;
import br.com.jonathanferreira.store.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestEMLifeCycle {
    public static void main(String[] args) {
        var category = new Category("Books");

        EntityManager em = JPAUtil.getEntityManager();

        CategoryDAO categoryDAO = new CategoryDAO(em);

        em.getTransaction().begin();
        em.persist(category);
        category.setName("Book");

        em.flush();
        em.clear();

        var cat = em.merge(category);
        cat.setName("testing");
        em.getTransaction().commit();
        em.close();
    }
}
