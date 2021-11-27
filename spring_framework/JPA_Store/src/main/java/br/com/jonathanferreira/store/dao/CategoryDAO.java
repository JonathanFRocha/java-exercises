package br.com.jonathanferreira.store.dao;

import br.com.jonathanferreira.store.model.Category;
import br.com.jonathanferreira.store.model.Product;

import javax.persistence.EntityManager;

public class CategoryDAO {

    private final EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Category cat){
        this.em.persist(cat);
    }

    public void update(Category cat) {
        this.em.merge(cat);
    }
}
