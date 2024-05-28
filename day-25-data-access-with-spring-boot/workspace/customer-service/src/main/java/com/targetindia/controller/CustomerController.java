package com.targetindia.controller;

import com.targetindia.service.CustomerService;
import com.targetindia.entity.Customer;
import com.targetindia.exception.ServiceException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@Validated
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<Customer> handlePostOne(@Valid @RequestBody Customer customer) {
        log.debug("received this customer data - {}", customer);
        Customer addedCustomer = service.addNewCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }
}
