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

    private String vendorCode;
    private String prodName;
    private Double prodCost;

    // Default Constructor
    public Product() {
    }

    // Constructor without prodId
    public Product(String vendorCode, String prodName, Double prodCost) {
        this.vendorCode = vendorCode;
        this.prodName = prodName;
        this.prodCost = prodCost;
    }

    // Getters and Setters
    public Integer getProdId() {
        return prodId;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Double getProdCost() {
        return prodCost;
    }

    public void setProdCost(Double prodCost) {
        this.prodCost = prodCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", vendorCode='" + vendorCode + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodCost=" + prodCost +
                '}';
    }
}


