package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Customer;
import com.dbs.movie_ticket_system.error.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);

    public List<Customer> fetchCustomerList();

    public Customer fetchCustomerById(Long customerId) throws CustomerNotFoundException;

    public void deleteCustomerById(Long customerId);

    public Customer updateCustomer(String customerName, Customer customer);

    public Customer fetchCustomerByName(String customerName);

    public List<Customer> fetchCustomerByPassword(String customerPassword);

}
