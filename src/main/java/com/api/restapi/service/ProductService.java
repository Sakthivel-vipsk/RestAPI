package com.api.restapi.service;

import com.api.restapi.entity.Product;
import com.api.restapi.repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private Product_Repository product_repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Save Product into DB
    public Product saveProduct(Product product) {
        return product_repository.save(product);
    }

    //Save list of Products
    public List<Product> saveProducts(List<Product> products) {
        return product_repository.saveAll(products);
    }

    //Get the Product Details from DB by ID
    public Product getProductByID(int id) {
        return product_repository.findById(id).orElse(null);
    }

    //Get the Product Details from DB by Name
    public Product getProductByName(String name) {
        return product_repository.findByName(name);
    }

    // Get Product Details from DB
    public List<Product> getAllProducts() {
        return product_repository.findAll();
    }

    //Delete the product by ID
    public String deleteProductByID(int id) {
        product_repository.deleteById(id);
        return "Product deleted !!";
    }

    //Delete Products
//    @Transactional
    public String deleteProducts() {
        product_repository.deleteAll();
//        jdbcTemplate.execute("ALTER TABLE product AUTO_INCREMENT = 1");
        return "All deleted !!";
    }

    //Update Products
    public String updateProduct(Product product) {
        Product exProduct = product_repository.findById(product.getId()).orElse(null);
        if (exProduct != null) {
            exProduct.setName(product.getName());
            exProduct.setPrice(product.getPrice());
            exProduct.setId(product.getId());
            exProduct.setQuantity(product.getQuantity());
            product_repository.save(exProduct);
            return "Product updated !!";
        }
        return "Product not found !!";
    }


}
