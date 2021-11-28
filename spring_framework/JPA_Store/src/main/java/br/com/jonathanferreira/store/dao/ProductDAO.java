package br.com.jonathanferreira.store.dao;

import br.com.jonathanferreira.store.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    public Product findById(Integer id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        String jpql = "SELECT p FROM Product p";
        return em.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> findByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name = :name";
        return em.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> findByCategoryName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
        return em.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    // Not using Criteria API
    public List<Product> SearchByParams(String name, BigDecimal price, LocalDate date) {
        String jpql = "SELECT p FROM Product p WHERE 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql = " AND p.name = :name";
        }
        if (price != null) {
            jpql = " AND p.price = :price";
        }
        if (date != null) {
            jpql = " AND p.registerDate = :date";
        }
        var query = em.createQuery(jpql, Product.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (price != null) {
            query.setParameter("price", price);
        }
        if (date != null) {
            query.setParameter("date", date);
        }

        return query.getResultList();
    }

    public List<Product> SearchByParamsUsingCriteria(String name, BigDecimal price, LocalDate date) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);

        Predicate filters = builder.and();
        if (name != null && !name.trim().isEmpty()) {
            filters = builder.and(filters, builder.equal(from.get("nome"), name));
        }
        if (price != null) {
            filters = builder.and(filters, builder.equal(from.get("price"), price));
        }
        if (date != null) {
            filters = builder.and(filters, builder.equal(from.get("registerDate"), date));
        }
        query.where(filters);
        return em.createQuery(query).getResultList();
    }
}
