package br.com.jonathanferreira.store.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "total_price")
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private LocalDate date = LocalDate.now();
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private final List<OrderItems> orderItemsList = new ArrayList<>();

    public Order() {
    }

    public Order(Client client) {
        this.client = client;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    public void addItem(OrderItems item) {
        item.setOrder(this);
        var totalValue = item.getUnitPrice().multiply(new BigDecimal(item.getQuantity()));
        setTotalPrice(totalValue);
        this.orderItemsList.add(item);
    }
}
