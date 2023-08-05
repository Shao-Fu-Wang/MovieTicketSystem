package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Customer customer = Customer.builder().customerName("Michael").customerPassword("test").customerMobileNumber("0928372772").build();
//        entityManager.persist(customer);
    }

    @Test
    @DisplayName("Get Customer Name Using ID")
    public void whenFindById_thenReturnCustomer() {
//        Customer customer = customerRepository.findById(1L).get();
//        assertEquals(customer.getCustomerName(), "Michael");
    }


}