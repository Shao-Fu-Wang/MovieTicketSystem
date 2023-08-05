package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.TicketLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketLevelRepository extends JpaRepository<TicketLevel, Long> {
}