package com.abb.categoryservice.controller;

import com.abb.categoryservice.dto.CategoryDTO;
import com.abb.categoryservice.exceptions.ResourceNotFoundException;
import com.abb.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<CategoryDTO> handleGetAll(){
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> handleGetOne(@PathVariable Integer id){
        var data = service.getCategory(id);
        if(data==null){
            throw new ResourceNotFoundException("No data found for id " + id);
        }
        return ResponseEntity.ok(data);
    }

}
