package com.targetindia.controller;

import com.targetindia.entity.Customer;
import com.targetindia.exception.ErrorResponse;
import com.targetindia.exception.ServiceException;
import com.targetindia.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<Customer> handlePostOne(@Valid @RequestBody Customer customer) {
        Customer addedCustomer = service.addNewCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity handleGetById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(service.getCustomerById(id));
        } catch (ServiceException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity handleGetAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(name="sort_by", defaultValue = "name") String sortBy){
        return ResponseEntity.ok(service.getAllCustomers(page, size, sortBy));
    }

    @GetMapping("/search")
    public List<Customer> handleGetByCity(@RequestParam String city){
        return service.getCustomersByCity(city);
    }

    // TODO: complete this application by handling PUT, PATCH, and DELETE requests
    // TODO: see if you can handle /search in a generic way (for example, search by email or phone or city)
}
