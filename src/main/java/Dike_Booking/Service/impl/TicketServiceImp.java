package Dike_Booking.Service.impl;

import Dike_Booking.Service.Ticket_Service;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class TicketServiceImp implements Ticket_Service{
    @Autowired
    TicketRepository repository;
    public List<Ticket_info> getTickets()
    {
        List<Ticket_info> allTickets=new ArrayList<Ticket_info>();

        Iterable<Ticket_info> tickets = repository.findAll();
        for(Ticket_info ticket: tickets)
        {
            allTickets.add(ticket);
        }
        return allTickets;
    }

}
