package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByMovieNameIgnoreCase(String movieName);
}
