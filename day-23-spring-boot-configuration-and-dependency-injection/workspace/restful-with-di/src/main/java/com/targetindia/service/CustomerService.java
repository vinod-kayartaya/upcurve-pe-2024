package com.targetindia.service;

import com.targetindia.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/*

A component is a class annotated with one of the following:

@Component                  --> generic; can be applied for any class that needs spring's attention
    @Repository             --> meant for DAO classes
    @Service                --> meant for business or application logic classes
    @Controller             --> meant for mvc controllers
        @RestController     --> meant for rest controller
    @Configuration          --> meant to contain certain configuration (such as security)

Spring boot will automatically create and load the objects of these classes, during the bootstrap.
This component scan happens only inside the package "com.targetindia". Any components that are
outside of this package, need to be scanned explicitly using @ComponentScan
*/

@Slf4j
@Service
public class CustomerService {
    // this class represents business or application logic
    // this is independent of any web or spring api

    private List<Customer> customers;

    public CustomerService() {
        log.debug("CustomerService class got instantiated");
        customers = new ArrayList<>();
        customers.add(new Customer("8bec3fb4-ae9e-423e-95c1-aef2d6ddd093", "Vinod Kumar", "vinod@vinod.co", "9731424784", "Bangalore"));
        customers.add(new Customer("0eb31b3d-dde3-4138-9c6e-124fe7264278", "Shyam Sundar", "shyam@xmpl.com", "9730004784", "Shivamogga"));
        customers.add(new Customer("d85be6a9-1715-4106-a9f9-d4e3118819b4", "John Doe", "johndoe@xmpl.com", "9731421234", "Dallas"));
    }

    public List<Customer> getAllCustomers() throws ServiceException {
        return customers;
    }


    public Customer getCustomerById(String id) {
        return customers
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Customer addNewCustomer(Customer customer) throws ServiceException{
        // do some validation
        // name/email are mandatory
        if (customer.getName() == null || customer.getEmail() == null) {
            throw new ServiceException("name/email are mandatory fields");
        }
        // email should be unique
        var customerCount = customers.stream()
                .filter(c -> c.getEmail().equals(customer.getEmail()))
                .count();
        if (customerCount > 0) {
            throw new ServiceException("a customer with this email already present in our database");
        }
        // phone if not null, should be unique
        if (customer.getPhone() != null) {
            customerCount = customers.stream()
                    .filter(c -> c.getPhone() != null && c.getPhone().equals(customer.getPhone()))
                    .count();
            if (customerCount > 0) {
                throw new ServiceException("a customer with this phone already present in our database");
            }
        }

        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);
        return customer;
    }
}
