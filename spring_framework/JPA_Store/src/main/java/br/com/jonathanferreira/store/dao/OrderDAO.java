package br.com.jonathanferreira.store.dao;

import br.com.jonathanferreira.store.model.Order;

import javax.persistence.EntityManager;

public class OrderDAO {
    private EntityManager em;

    public OrderDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Order order){
        this.em.persist(order);
    }
}
