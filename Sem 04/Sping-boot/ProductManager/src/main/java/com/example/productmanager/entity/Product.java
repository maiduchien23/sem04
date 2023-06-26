package com.example.productmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "product_name")
    public String productName;

    @Column(name = "brand")
    public String brand;

    @Column(name = "price")
    public Double price;

    @Column(name = "description")
    public String description;

    @Column(name = "quantity")
    public int quantity;

    public Product(int id, String productName, String brand, Double price, String description, int quantity) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(String productName, String brand, Double price, String description, int quantity) {
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}