package com.abb.productservice.controller;


import com.abb.productservice.dto.ProductDTO;
import com.abb.productservice.exceptions.ResourceNotFoundException;
import com.abb.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductDTO> handleGetAll(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> handleGetOne(@PathVariable Integer id){
        var data = service.getProduct(id);
        if(data==null){
            throw new ResourceNotFoundException("No data found for id " + id);
        }
        return ResponseEntity.ok(data);
    }

}
