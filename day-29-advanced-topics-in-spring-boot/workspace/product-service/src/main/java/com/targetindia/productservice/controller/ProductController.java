package com.targetindia.productservice.controller;

import com.targetindia.productservice.entity.Product;
import com.targetindia.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/for-category/{id}")
    public List<Product> handleGetProductsForCategory(@PathVariable Integer id){
        return service.getProductsForCategory(id);
    }
}
