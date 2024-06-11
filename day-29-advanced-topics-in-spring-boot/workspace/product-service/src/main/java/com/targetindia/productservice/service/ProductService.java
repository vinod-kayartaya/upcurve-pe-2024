package com.targetindia.productservice.service;

import com.targetindia.productservice.entity.Product;
import com.targetindia.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getProductsForCategory(Integer categoryId){
        return repo.findAllByCategoryId(categoryId);
    }
}
