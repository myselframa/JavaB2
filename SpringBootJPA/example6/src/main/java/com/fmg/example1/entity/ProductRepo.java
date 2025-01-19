package com.fmg.example1.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	// Query to fetch all products where vendorCode matches or prodCost is greater than a specific value
    @Query("SELECT p FROM Product p WHERE p.vendorCode = :a OR p.prodCost > :b")
    List<Product> getAllProducts(@Param("a") String vendorCode, @Param("b") Double prodCost);

    // Query to fetch only product codes where vendorCode matches or prodCost equals a specific value
    @Query("SELECT p.vendorCode FROM Product p WHERE p.vendorCode = ?1 OR p.prodCost = ?2")
    List<String> getAllProductCodes(String vendorCode, Double prodCost);

    // Query to fetch product codes and costs for all products
    @Query("SELECT p.vendorCode, p.prodCost FROM Product p")
    List<Object[]> getAllProductData();


}
