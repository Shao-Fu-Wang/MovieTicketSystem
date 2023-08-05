package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByCustomerNameIgnoreCase(String customerName);

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE c set c.customer_password = 123 ticketsystem.customer where customer_password = ?1, nativeQuery = true)
//    int updatePwd(String password);
    public List<Customer> findByCustomerPassword(String customerPassword);
}
