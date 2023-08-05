package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Admin;
import com.dbs.movie_ticket_system.entity.Customer;
import com.dbs.movie_ticket_system.repository.AdminRepository;
import com.dbs.movie_ticket_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByCustomerNameIgnoreCase(username);
        Admin admin = adminRepository.findByAdminNameIgnoreCase(username);
        if (customer == null && admin == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(admin, customer);
    }
}
