package Dike_Booking.api;

import Dike_Booking.Service.Card_Service;
import Dike_Booking.Service.Ticket_Service;
import Dike_Booking.domain.Credit_card_details;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.model.Credit_card_detailsResource;
import Dike_Booking.model.Ticket_infoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping(value="/Ticket/**")
public class Ticket_Info_Page {
    @Autowired
    private Ticket_Service service;
    @RequestMapping(value = "/Ticket", method = RequestMethod.GET)

    public List<Ticket_infoResource> getTicket() {
        List<Ticket_infoResource> hateos = new ArrayList<>();
        List<Ticket_info> info = service.getTickets();
        for (Ticket_info ticket : info) {
            Ticket_infoResource res = new Ticket_infoResource
                    .Builder(ticket.getTick_num())
                    .event_date(ticket.getEvent_date())
                    .status(ticket.getStatus())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
