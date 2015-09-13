package Dike_Booking.config_factory;

import Dike_Booking.domain.Ticket_info;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class TicketFactory {
    public static Integer tick_num;
    public static Ticket_info createTicket(Map<String, String> values)

    {
        Ticket_info info = new Ticket_info
                .Builder(tick_num)
                .event_date(values.get("event_date"))
                .status(values.get("status"))
                .build();
        return info;
    }
}
