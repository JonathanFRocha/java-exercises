package br.com.jonathanferreira.store.dao;

import br.com.jonathanferreira.store.model.Order;
import br.com.jonathanferreira.store.vo.SalesReportVO;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDAO {
    private EntityManager em;

    public OrderDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Order order) {
        this.em.persist(order);
    }

    public BigDecimal totalValueSold() {
        String jpql = "SELECT SUM(o.totalPrice) FROM Order as o";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<SalesReportVO> salesReport() {
        String jpql = "SELECT new br.com.jonathanferreira.store.vo.SalesReportVO(product.name, SUM(orderItems.quantity), MAX(o.date)) " +
                "FROM Order o " +
                "JOIN o.orderItemsList orderItems " +
                "JOIN orderItems.product product " +
                "GROUP BY product.name " +
                "ORDER BY orderItems.quantity DESC";

        return em.createQuery(jpql, SalesReportVO.class)
                .getResultList();
    }
}
