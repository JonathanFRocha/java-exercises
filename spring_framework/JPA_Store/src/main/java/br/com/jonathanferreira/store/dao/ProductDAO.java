package br.com.jonathanferreira.store.dao;

import br.com.jonathanferreira.store.model.Product;

import javax.persistence.EntityManager;

public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Product product) {
        this.em.persist(product);
    }

    public void update(Product product) {
        this.em.merge(product);
    }

    public void remove(Product product) {
        product = em.merge(product);
        this.em.remove(product);
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }
}
