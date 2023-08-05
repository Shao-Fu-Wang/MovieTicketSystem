package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.OccupiedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupiedSeatRepository extends JpaRepository<OccupiedSeat, Long> {
}
