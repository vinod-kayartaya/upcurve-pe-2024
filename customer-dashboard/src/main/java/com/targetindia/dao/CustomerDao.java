package com.targetindia.dao;

import com.targetindia.model.Customer;

import java.util.List;

public interface CustomerDao {

    // CRUD operations
    public String save(Customer customer) throws DaoException;

    public Customer findById(String id) throws DaoException;

    public void update(Customer customer) throws DaoException;

    public void delete(String id) throws DaoException;

    // Query operations

    public List<Customer> findAll() throws DaoException;

    public List<Customer> findAllByCity(String city) throws DaoException;

    public Customer findByEmail(String email) throws DaoException;

    public Customer findByPhone(String phone) throws DaoException;

    public List<Customer> findByAgeGroup(Integer fromAge, Integer toAge) throws DaoException;
}
