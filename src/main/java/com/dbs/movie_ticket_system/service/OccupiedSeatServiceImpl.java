package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.OccupiedSeat;
import com.dbs.movie_ticket_system.repository.OccupiedSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupiedSeatServiceImpl implements OccupiedSeatService {
    @Autowired
    OccupiedSeatRepository occupiedSeatRepository;

    @Override
    public List<OccupiedSeat> fetchOccupiedSeatList() {
        return occupiedSeatRepository.findAll();
    }
}
