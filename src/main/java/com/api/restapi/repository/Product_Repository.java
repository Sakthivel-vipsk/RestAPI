package com.api.restapi.repository;

import com.api.restapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_Repository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
