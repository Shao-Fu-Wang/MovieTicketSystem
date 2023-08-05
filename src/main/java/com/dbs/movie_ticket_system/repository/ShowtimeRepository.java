package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}
