package com.targetindia.categoryservice.service;

import com.targetindia.categoryservice.entity.Category;
import com.targetindia.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public List<Category> getAll(){
        return repo.findAll();
    }

    public Category getById(Integer id){
        return repo.findById(id).orElse(null);
    }
}
