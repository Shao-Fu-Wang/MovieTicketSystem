package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByAdminNameIgnoreCase(String admin);

}
