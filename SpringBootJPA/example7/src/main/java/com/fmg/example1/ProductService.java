package com.fmg.example1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmg.example1.entity.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    public List<ProductRepo.MyView> getVendorCodeAndCost(String vendorCode) {
        return productRepository.findByVendorCode(vendorCode, ProductRepo.MyView.class);
    }

    public List<ProductRepo.MyViewTwo> getProdIdAndCost(String vendorCode) {
        return productRepository.findByVendorCode(vendorCode, ProductRepo.MyViewTwo.class);
    }
}

