package Dike_Booking.api;

import Dike_Booking.Service.SportService;
import Dike_Booking.Service.Ticket_Service;
import Dike_Booking.domain.Sport;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.model.SportResource;
import Dike_Booking.model.Ticket_infoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping(value="/Sport/**")
public class SportPage {
    @Autowired
    private SportService service;
    @RequestMapping(value = "/Sport", method = RequestMethod.GET)

    public List<SportResource> getSport() {
        List<SportResource> hateos = new ArrayList<>();
        List<Sport> sports = service.getSport();
        for (Sport sport : sports) {
            SportResource res = new SportResource
                    .Builder(sport.getSport_type())
                    .sport_id(sport.getSport_id())
                    .team(sport.getTeam())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
