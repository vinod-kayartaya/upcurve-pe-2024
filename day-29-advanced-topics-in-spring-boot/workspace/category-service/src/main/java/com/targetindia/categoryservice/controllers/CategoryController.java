package com.targetindia.categoryservice.controllers;

import com.targetindia.categoryservice.entity.Category;
import com.targetindia.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(produces = "application/json")
    public List<Category> handleGetAll(){
        return service.getAll();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity handleGetOne(@PathVariable Integer id){
        var c = service.getById(id);
        if(c==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(c);
    }

    @GetMapping(path="/{id}/picture", produces = "image/jpeg")
    public ResponseEntity handleGetCategoryPicture(@PathVariable Integer id){
        var c = service.getById(id);
        if(c==null){
            return ResponseEntity.notFound().build();
        }

        try(FileInputStream file = new FileInputStream("beverages.jpeg");){

            int size = file.available();
            byte[] picture = new byte[size];
            file.read(picture);
            return ResponseEntity.ok(picture);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return ResponseEntity.ok(c.getPicture());
    }
}
