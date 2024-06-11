package com.targetindia.productservice.repository;

import com.targetindia.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByCategoryId(Integer categoryId);
}
