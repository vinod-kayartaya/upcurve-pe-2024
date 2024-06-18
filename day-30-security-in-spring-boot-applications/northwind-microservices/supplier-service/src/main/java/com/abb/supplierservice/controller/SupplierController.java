package com.abb.supplierservice.controller;


import com.abb.supplierservice.dto.SupplierDTO;
import com.abb.supplierservice.exceptions.ResourceNotFoundException;
import com.abb.supplierservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/suppliers", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class SupplierController {

    @Autowired
    private SupplierService service;

    @GetMapping
    public List<SupplierDTO> handleGetAll(){
        return service.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> handleGetOne(@PathVariable Integer id){
        var data = service.getSupplier(id);
        if(data==null){
            throw new ResourceNotFoundException("No data found for id " + id);
        }
        return ResponseEntity.ok(data);
    }

}

