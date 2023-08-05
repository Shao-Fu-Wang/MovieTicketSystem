package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.TicketLevel;

import java.util.List;

public interface TicketLevelService {
    public List<TicketLevel> fetchTicketLevelsList();
    public TicketLevel saveTicketLevel(TicketLevel ticketLevel);
}
