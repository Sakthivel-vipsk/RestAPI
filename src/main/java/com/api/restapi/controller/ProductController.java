package com.api.restapi.controller;

import com.api.restapi.entity.Product;
import com.api.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/GetAllProducts")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/GetProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductByID(id);
    }

    @GetMapping("/GetProductByName/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/UpdateProduct")
    public String updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/DeleteByID/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProductByID(id);
    }

    @DeleteMapping("/DeleteAll")
    public String deleteAllProducts() {
        return service.deleteProducts();
    }
}
