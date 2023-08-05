package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Admin;
import com.dbs.movie_ticket_system.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final Admin admin;
    private final Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.admin != null) {
            return Collections.singleton(new SimpleGrantedAuthority("ADMIN_ROLE"));
        }
        return Collections.singleton(new SimpleGrantedAuthority("CUSTOMER_ROLE"));
    }

    @Override
    public String getPassword() {
        if (this.admin != null) {
            return admin.getAdminPassword();
        }
        return customer.getCustomerPassword();
    }

    @Override
    public String getUsername() {
        if (this.admin != null) {
            return admin.getAdminName();
        }
        return customer.getCustomerName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
