package br.com.jonathanferreira.store.dao;

import br.com.jonathanferreira.store.model.Client;
import br.com.jonathanferreira.store.model.Product;

import javax.persistence.EntityManager;

public class ClientDAO {
    private EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Client client) {
        this.em.persist(client);
    }

    public Client findById(Integer id) {

        return em.find(Client.class, id);

    }
}
