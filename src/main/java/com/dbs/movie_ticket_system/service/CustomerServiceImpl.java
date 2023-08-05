package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Customer;
import com.dbs.movie_ticket_system.error.CustomerNotFoundException;
import com.dbs.movie_ticket_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchCustomerById(Long customerId) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(!customer.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found");
        }
        return customer.get();
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(String customerName, Customer customer){
        Customer customerDB = customerRepository.findByCustomerNameIgnoreCase(customerName);
        if(Objects.nonNull(customer.getCustomerName()) && !"".equalsIgnoreCase(customer.getCustomerName())){
            customerDB.setCustomerName(customer.getCustomerName());
        }
        if(Objects.nonNull(customer.getCustomerMobileNumber()) && !"".equalsIgnoreCase(customer.getCustomerMobileNumber())){
            customerDB.setCustomerMobileNumber(customer.getCustomerMobileNumber());
        }
        if(Objects.nonNull(customer.getCustomerPassword()) && !"".equalsIgnoreCase(customer.getCustomerPassword())){
            customerDB.setCustomerPassword(new BCryptPasswordEncoder().encode(customer.getCustomerPassword()));
        }
        return customerRepository.save(customerDB);
    }

    @Override
    public Customer fetchCustomerByName(String customerName) {
        return customerRepository.findByCustomerNameIgnoreCase(customerName);
    }

    @Override
    public List<Customer> fetchCustomerByPassword(String customerPassword) {
        return customerRepository.findByCustomerPassword(customerPassword);
    }
}
