package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.TicketLevel;
import com.dbs.movie_ticket_system.repository.TicketLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketLevelServiceImpl implements TicketLevelService{
    @Autowired
    TicketLevelRepository ticketLevelRepository;

    @Override
    public List<TicketLevel> fetchTicketLevelsList() {
        return ticketLevelRepository.findAll();
    }

    public TicketLevel saveTicketLevel(TicketLevel ticketLevel){
        return ticketLevelRepository.save(ticketLevel);
    }
}
