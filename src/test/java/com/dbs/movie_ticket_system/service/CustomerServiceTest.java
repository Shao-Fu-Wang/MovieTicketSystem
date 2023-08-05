package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Customer;
import com.dbs.movie_ticket_system.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customer = Customer.builder().customerId(1L).customerName("Michael").customerMobileNumber("0986372711").customerPassword("test").build();
        Mockito.when(customerRepository.findByCustomerNameIgnoreCase("Michael")).thenReturn(customer);
    }

    @Test
    @DisplayName("Get Data Based On Valid Customer Name")
    public void whenValidCustomerName_thenCustomerShouldBeFound() {
        String customerName = "Michael";
        Customer found = customerService.fetchCustomerByName(customerName);
        assertEquals(customerName, found.getCustomerName());
    }
}