package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Showtime;
import com.dbs.movie_ticket_system.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShowtimeServiceImpl implements ShowtimeService{
    @Autowired
    ShowtimeRepository showtimeRepository;
    @Override
    public List<Showtime> fetchShowtimeList() {
        return showtimeRepository.findAll();
    }
}
