package com.targetindia.service;

import com.targetindia.entity.Customer;
import com.targetindia.exception.ServiceException;
import com.targetindia.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer addNewCustomer(@Valid Customer customer){
        try{
            return repo.save(customer);
        }
        catch (DataIntegrityViolationException ex){
            throw new ServiceException("Email or phone number already exists");
        }
    }
}
