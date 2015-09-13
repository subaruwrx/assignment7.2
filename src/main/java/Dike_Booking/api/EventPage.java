package Dike_Booking.api;

import Dike_Booking.Service.Event_Service;
import Dike_Booking.Service.Music_Service;
import Dike_Booking.domain.Event;
import Dike_Booking.domain.Music;
import Dike_Booking.model.EventResource;
import Dike_Booking.model.MusicResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@RestController
@RequestMapping(value="/event/**")
public class EventPage  {
    @Autowired
    private Event_Service service;
    @RequestMapping(value = "/event", method = RequestMethod.GET)

    public List<EventResource> getEvents() {
        List<EventResource> hateos = new ArrayList<>();
        List<Event> eventlist = service.getEvents();
        for (Event event : eventlist) {
            EventResource res = new EventResource
                    .Builder(event.getEvent_type())
                    .name(event.getEvent_name())
                    .event_id(event.getEvent_id())
                    .place(event.getPlace())
                    .price(event.getPrice())
                    .date(event.getDate())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }

}
