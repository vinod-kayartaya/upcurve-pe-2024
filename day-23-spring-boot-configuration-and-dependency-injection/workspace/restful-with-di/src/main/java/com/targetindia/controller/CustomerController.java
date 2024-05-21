package com.targetindia.controller;

import com.targetindia.model.Customer;
import com.targetindia.service.CustomerService;
import com.targetindia.service.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService service; // dependency

    @GetMapping(produces = "application/json")
    public List<Customer> handleGetAll() {
        return service.getAllCustomers();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity handleGetOne(@PathVariable String id) {
        Customer customer = service.getCustomerById(id);
        if (customer == null) {
            return error(404, "no customer found for id " + id);
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity handlePost(@RequestBody List<Customer> customers) throws URISyntaxException {

        List<Customer> success = new ArrayList<>();
        List<Object> errors = new ArrayList<>();

        for(Customer customer: customers){
            try{
                customer = service.addNewCustomer(customer);
                success.add(customer);
            }
            catch (ServiceException e){
                Map<String, Object> record = new LinkedHashMap<>();
                record.put("error", e.getMessage());
                record.put("customer", customer);
                errors.add(record);
            }
        }
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("savedCustomers", success);
        data.put("failedCustomers", errors);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity handlePut(@PathVariable String id, @RequestBody Customer customer) {
        // TODO: implement this in the similar fashion as the POST hanlder
        return null;
    }


    @PatchMapping("/{id}")
    public ResponseEntity handlePatch(@PathVariable String id, @RequestBody Customer customer) {
        // TODO: implement this in the similar fashion as the POST hanlder
        return null;
    }

    // TODO: implement delete handler in the similar fashion as the POST hanlder

    // helper function; customizable
    ResponseEntity error(int statusCode, String message) {
        Map<String, Object> err = new LinkedHashMap<>();
        err.put("message", message);
        err.put("timestamp", new Date());
        return ResponseEntity.status(statusCode).body(err);
    }

}
