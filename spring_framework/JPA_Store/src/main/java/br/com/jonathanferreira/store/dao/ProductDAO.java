package br.com.jonathanferreira.store.dao;

import br.com.jonathanferreira.store.model.Product;

import javax.persistence.EntityManager;

public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Product product){
        this.em.persist(product);
    }
}
