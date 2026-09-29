package edu.ianexline.products.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class OrderEntity {

    @Id
    @Column("ID")
    private Integer id;

    @Column("ORDER_NUMBER")
    private String orderNumber;

    @Column("PRODUCT_NAME")
    private String productName;

    @Column("PRICE")
    private float price;

    @Column("QTY")
    private int quantity;

    public OrderEntity() {
    }

    public OrderEntity(Integer id, String orderNumber, String productName, float price, int quantity) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}