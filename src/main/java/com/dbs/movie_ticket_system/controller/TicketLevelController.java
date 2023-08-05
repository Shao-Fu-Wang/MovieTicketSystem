package com.dbs.movie_ticket_system.controller;

import com.dbs.movie_ticket_system.entity.TicketLevel;
import com.dbs.movie_ticket_system.service.MovieService;
import com.dbs.movie_ticket_system.service.TicketLevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketLevelController {
    @Autowired
    private TicketLevelService ticketLevelService;
    @Autowired
    private MovieService movieService;
    private final Logger LOGGER = LoggerFactory.getLogger(TicketLevelController.class);

    @GetMapping("/ticketlevels")
    public List<TicketLevel> fetchTicketLevels() {
        LOGGER.info("fetched");
        return ticketLevelService.fetchTicketLevelsList();
    }

    @PostMapping("/ticketlevels/{movie_name}")
    public TicketLevel saveTicketLevel(@PathVariable("movie_name") String movieName,
                                       @RequestBody TicketLevel ticketLevel) {
        ticketLevel.setMovie(movieService.fetchMovieByName(movieName));
        LOGGER.info("uploading ticket-level");
        return ticketLevelService.saveTicketLevel(ticketLevel);
    }
}
