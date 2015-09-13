package Dike_Booking.Service.impl;

import Dike_Booking.Service.Event_Service;
import Dike_Booking.domain.Credit_card_details;
import Dike_Booking.domain.Event;
import Dike_Booking.repository.CardRepository;
import Dike_Booking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class EventServiceImp implements Event_Service{
    @Autowired
    EventRepository repository;
    public List<Event> getEvents()
    {
        List<Event> allEvents=new ArrayList<Event>();

        Iterable<Event> events = repository.findAll();
        for(Event event: events)
        {
            allEvents.add(event);
        }
        return allEvents;
    }
}
