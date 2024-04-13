package com.targetindia.service;

import com.targetindia.dao.CustomerDao;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.SerializationCustomerDao;
import com.targetindia.model.Customer;

import java.util.List;

public class CustomerService {

    final CustomerDao dao;

    public CustomerService() {
        dao = new SerializationCustomerDao(); // right now this tight coupling; need to change;
    }

    public Customer addNewCustomer(Customer customer) throws ServiceException {
        try {
            // do some basic validation; for any violation, throw a ServiceException
            // 1. name, email, phone --> mandatory
            // 2. email must be unique
            // 3. phone must be unique
            // 4. email must be a proper email (use regex)
            // 5. phone must be a 10 digit number

            var id = dao.save(customer);
            customer.setId(id);
            return customer;

        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Customer> getAllCustomers() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
