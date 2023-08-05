package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> fetchAdminByName(String admin);
}
