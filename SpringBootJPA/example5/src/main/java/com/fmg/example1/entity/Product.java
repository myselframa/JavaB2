package com.fmg.example1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodId;

    private String prodCode;
    private String prodName;
    private double prodCost;

    // Default Constructor
    public Product() {
    }

    // Constructor without prodId
    public Product(String prodCode, String prodName, double prodCost) {
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.prodCost = prodCost;
    }

    // Getters and Setters
    public Integer getProdId() {
        return prodId;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdCost() {
        return prodCost;
    }

    public void setProdCost(double prodCost) {
        this.prodCost = prodCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodCode='" + prodCode + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodCost=" + prodCost +
                '}';
    }
}

