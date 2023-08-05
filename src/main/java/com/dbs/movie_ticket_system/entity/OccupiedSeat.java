package com.dbs.movie_ticket_system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OccupiedSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long occupiedSeatId;
    private String occupiedSeatPhyRowId;
    private Integer occupiedSeatNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_book_id")
    private OrderBook orderBook;
}
