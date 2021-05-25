package com.alevel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "order_details", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductEntity> products;

    @Column(name = "quantity")
    int quantity;

    public OrderDetailsEntity() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> productIds) {
        this.products = productIds;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
