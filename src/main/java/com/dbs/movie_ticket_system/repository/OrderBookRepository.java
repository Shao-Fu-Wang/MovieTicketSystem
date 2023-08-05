package com.dbs.movie_ticket_system.repository;

import com.dbs.movie_ticket_system.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
}