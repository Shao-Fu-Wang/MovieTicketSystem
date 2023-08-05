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
public class TicketLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketLevelId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId")
    private Movie movie;
    private Integer ticketLevelBronze;
    private Integer ticketLevelSilver;
    private Integer ticketLevelGold;
}
