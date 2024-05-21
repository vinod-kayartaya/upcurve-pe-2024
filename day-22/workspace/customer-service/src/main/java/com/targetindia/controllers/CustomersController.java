package com.targetindia.controllers;

import com.targetindia.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

// @RestController
// @RequestMapping
// @GetMapping
// @PostMapping
// @PathVariable
// @RequestBody
// ResponseEntity

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomersController {

    private List<Customer> customers;

    public CustomersController() {
        customers = new ArrayList<>();
        customers.add(new Customer("8bec3fb4-ae9e-423e-95c1-aef2d6ddd093", "Vinod Kumar", "vinod@vinod.co", "9731424784", "Bangalore"));
        customers.add(new Customer("0eb31b3d-dde3-4138-9c6e-124fe7264278", "Shyam Sundar", "shyam@xmpl.com", "9730004784", "Shivamogga"));
        customers.add(new Customer("d85be6a9-1715-4106-a9f9-d4e3118819b4", "John Doe", "johndoe@xmpl.com", "9731421234", "Dallas"));
    }

    @GetMapping(produces = "application/json")
    public List<Customer> handleGetAll() {
        return customers;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity handleGetOne(@PathVariable String id) {
        Customer customer = customers
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (customer == null) {
            Map<String, Object> err = new LinkedHashMap<>();
            err.put("message", "no customer data found for id " + id);
            err.put("timestamp", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }

        return ResponseEntity.ok(customer);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity handlePost(@RequestBody Customer customer) throws URISyntaxException {
        // do some validation
        Map<String, Object> err = new LinkedHashMap<>();
        // name/email are mandatory
        if (customer.getName() == null || customer.getEmail() == null) {
            err.put("message", "name/email are mandatory fields");
            err.put("timestamp", new Date());
            return ResponseEntity.badRequest().body(err);
        }
        // email should be unique
        var customerCount = customers.stream()
                .filter(c -> c.getEmail().equals(customer.getEmail()))
                .count();
        if (customerCount > 0) {
            err.put("message", "a customer with this email already present in our database");
            err.put("timestamp", new Date());
            return ResponseEntity.badRequest().body(err);
        }
        // phone if not null, should be unique
        if (customer.getPhone() != null) {
            customerCount = customers.stream()
                    .filter(c -> c.getPhone() != null && c.getPhone().equals(customer.getPhone()))
                    .count();
            if (customerCount > 0) {
                err.put("message", "a customer with this phone already present in our database");
                err.put("timestamp", new Date());
                return ResponseEntity.badRequest().body(err);
            }
        }

        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);
        return ResponseEntity.created(new URI("/api/customers/" + customer.getId())).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity handlePut(@PathVariable String id, @RequestBody Customer customer) {
        log.debug("received id as {} and customer as {}", id, customer);

        // check if a customer exists with the given id; if not respond with 404
        var existingCustomer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);

        Map<String, Object> err = new LinkedHashMap<>();
        if (existingCustomer == null) {
            err.put("message", "no customer data found for id " + id);
            err.put("timestamp", new Date());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err);
        }

        // since the customer exists, let's check if the user has forgotten to send the
        // required fields, such as name/email
        if (customer.getName() == null || customer.getEmail() == null) {
            err.put("message", "name/email are mandatory fields");
            err.put("timestamp", new Date());
            return ResponseEntity.badRequest().body(err);
        }

        // check if the email given is not matching with any other emails
        var anotherCustomerWithGivenEmail = customers.stream()
                .filter(c -> !c.getId().equals(id) && c.getEmail().equals(customer.getEmail()))
                .findFirst()
                .orElse(null);

        if (anotherCustomerWithGivenEmail != null) {
            err.put("message", "the email matches another customer's email");
            err.put("timestamp", new Date());
            return ResponseEntity.badRequest().body(err);
        }

        // check if the phone given is not matching with any other phones (only if phone is supplied)
        if (customer.getPhone() != null) {
            var anotherCustomerWithGivenPhone = customers.stream()
                    .filter(c -> !c.getId().equals(id))
                    .filter(c -> c.getPhone() != null)
                    .filter(c -> c.getPhone().equals(customer.getPhone()))
                    .findFirst()
                    .orElse(null);

            if (anotherCustomerWithGivenPhone != null) {
                err.put("message", "the phone matches another customer's phone");
                err.put("timestamp", new Date());
                return ResponseEntity.badRequest().body(err);
            }
        }

        // all is well;

        var index = customers.indexOf(existingCustomer);
        customer.setId(id);
        customers.set(index, customer);

        return ResponseEntity.ok(customer);
    }


    @PatchMapping("/{id}")
    public ResponseEntity handlePatch(@PathVariable String id, @RequestBody Customer customer) {
        log.debug("received id as {} and customer as {}", id, customer);

        // check if a customer exists with the given id; if not respond with 404
        var existingCustomer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);

        Map<String, Object> err = new LinkedHashMap<>();
        if (existingCustomer == null) {
            err.put("message", "no customer data found for id " + id);
            err.put("timestamp", new Date());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err);
        }

        // update name if not null
        if(customer.getName()!=null){
            existingCustomer.setName(customer.getName());
        }

        // update email if not null and if not duplicate
        if(customer.getEmail()!=null){
            var anotherCustomerWithGivenEmail = customers.stream()
                    .filter(c -> !c.getId().equals(id) && c.getEmail().equals(customer.getEmail()))
                    .findFirst()
                    .orElse(null);

            if (anotherCustomerWithGivenEmail != null) {
                err.put("message", "the email matches another customer's email");
                err.put("timestamp", new Date());
                return ResponseEntity.badRequest().body(err);
            }

            existingCustomer.setEmail(customer.getEmail());
        }

        // update phone if not null and if not duplicate
        if(customer.getPhone()!=null){
            if (customer.getPhone() != null) {
                var anotherCustomerWithGivenPhone = customers.stream()
                        .filter(c -> !c.getId().equals(id))
                        .filter(c -> c.getPhone() != null)
                        .filter(c -> c.getPhone().equals(customer.getPhone()))
                        .findFirst()
                        .orElse(null);

                if (anotherCustomerWithGivenPhone != null) {
                    err.put("message", "the phone matches another customer's phone");
                    err.put("timestamp", new Date());
                    return ResponseEntity.badRequest().body(err);
                }
            }

            existingCustomer.setPhone(customer.getPhone());
        }

        // update city if not null
        if(customer.getCity()!=null){
            existingCustomer.setCity(customer.getCity());
        }

        return ResponseEntity.ok(existingCustomer);
    }

}
