package com.dbs.movie_ticket_system.controller;

import com.dbs.movie_ticket_system.entity.Customer;
import com.dbs.movie_ticket_system.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = Customer.builder().customerId(1L).customerName("Michael").customerMobileNumber("0982637266").customerPassword("pwd").build();
    }

    @Test
    void saveCustomer() throws Exception {
        Customer inputCustomer = Customer.builder().customerName("Michael").customerMobileNumber("0982637266").customerPassword("pwd").build();
        Mockito.when(customerService.saveCustomer(inputCustomer)).thenReturn(customer);
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"customerName\": \"Michael\",\n" +
                        "    \"customerMobileNumber\": \"0999364777\",\n" +
                        "    \"customerPassword\": \"passddd\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchCustomerByName() throws Exception {
        Mockito.when(customerService.fetchCustomerById(1L)).thenReturn(customer);
        mockMvc.perform(get("/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerName").value(customer.getCustomerName()));
    }
}