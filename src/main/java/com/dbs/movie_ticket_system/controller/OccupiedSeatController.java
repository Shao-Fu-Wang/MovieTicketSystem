package com.dbs.movie_ticket_system.controller;

import com.dbs.movie_ticket_system.entity.OccupiedSeat;
import com.dbs.movie_ticket_system.service.OccupiedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OccupiedSeatController {
    @Autowired
    private OccupiedSeatService occupiedSeatService;


    @GetMapping("/seat/occupied")
    public List<OccupiedSeat> fetchSeatList() {
        return occupiedSeatService.fetchOccupiedSeatList();
    }
}
