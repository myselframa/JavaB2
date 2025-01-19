package com.fmg.example1.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends JpaRepository<Product, Integer>{

    // Projection for VendorCode and ProdCost
    interface MyView {
        String getVendorCode();
        Double getProdCost();
    }

    // Projection for ProdId and ProdCost
    interface MyViewTwo {
        Integer getProdId();
        Double getProdCost();
    }

    // Dynamic projection method
    <T> List<T> findByVendorCode(String vc, Class<T> clz);



}
