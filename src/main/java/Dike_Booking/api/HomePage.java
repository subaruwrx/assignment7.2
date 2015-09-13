package Dike_Booking.api;

import Dike_Booking.Service.Event_Service;
import Dike_Booking.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hashcode on 2015/04/07.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private Event_Service service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/event",method = RequestMethod.GET)
    public Event getEvent(){
        Event event = new Event
                .Builder("Music festival")
                .name("Mafuce festival")
                .event_id(1009l)
                .place("Bloemfontain")
                .price(1500)
                .date("10/October/2015")
                .build();

        return event;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents(){


        return service.getEvents();
    }




}
