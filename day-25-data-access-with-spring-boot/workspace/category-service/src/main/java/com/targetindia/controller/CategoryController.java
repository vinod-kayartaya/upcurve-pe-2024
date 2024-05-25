package com.targetindia.controller;

import com.targetindia.entity.Category;
import com.targetindia.model.ErrorResponse;
import com.targetindia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handleGetOne(@PathVariable Integer id){
        Category category = service.getCategory(id);
        if(category==null){
            return ResponseEntity.status(404).body(new ErrorResponse("no data found"));
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handleGetAll(){
        return ResponseEntity.ok(service.getAllCategories());
    }
}
