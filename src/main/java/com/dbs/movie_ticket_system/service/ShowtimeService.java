package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Showtime;

import java.util.List;

public interface ShowtimeService {
    public List<Showtime> fetchShowtimeList();
}
