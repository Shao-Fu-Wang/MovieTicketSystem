package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.OccupiedSeat;

import java.util.List;

public interface OccupiedSeatService {

    List<OccupiedSeat> fetchOccupiedSeatList();


}
