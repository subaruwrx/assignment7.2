package Dike_Booking.config_factory;

import Dike_Booking.domain.Event;
import java.util.Map;

/**
 * Created by student on 2015/04/25.
 */

public class EventFactory {
    private static Long event_id;
    public static Event createEvents(int price,Map<String,String>values)
    {

        Event event= new Event
                .Builder(values.get("event_type"))
                .name(values.get("event_name"))
                .event_id(event_id)
                .place(values.get("place"))
                .price(price)
                .date(values.get("date"))
                .build();
        return event;
    }
}
