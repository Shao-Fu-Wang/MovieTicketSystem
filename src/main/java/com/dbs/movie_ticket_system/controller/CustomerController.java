package com.dbs.movie_ticket_system.controller;

import com.dbs.movie_ticket_system.entity.Customer;
import com.dbs.movie_ticket_system.error.CustomerNotFoundException;
import com.dbs.movie_ticket_system.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/register")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        LOGGER.info("Inside saveCustomer of CustomerController");
        customer.setCustomerPassword(new BCryptPasswordEncoder().encode(customer.getCustomerPassword()));
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> fetchCustomerList() {
        return customerService.fetchCustomerList();
    }

    @GetMapping("/customers/{id}")
    public Customer fetchCustomerById(@PathVariable("id") Long customerId) throws CustomerNotFoundException {
        return customerService.fetchCustomerById(customerId);
    }

    @GetMapping("/customers/name/{name}")
    public Customer fetchCustomerByName(@PathVariable("name") String customerName) {
        return customerService.fetchCustomerByName(customerName);
    }
    @PutMapping("/customers/{name}")
    public Customer updateCustomer(@PathVariable("name") String customerName,
                                   @RequestBody Customer customer) {
        return customerService.updateCustomer(customerName, customer);
    }
    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId) {
        customerService.deleteCustomerById(customerId);
        return "Customer id: " + customerId + " deleted Successfully";
    }



//    @GetMapping("/customers/password/{password}")
//    public List<Customer> fetchCustomerByPassword(@PathVariable("password") String customerPassword) {
//        return customerService.fetchCustomerByPassword(customerPassword);
//    }
}
