package Dike_Booking.config_factory;


import Dike_Booking.domain.Bus;

import java.util.Map;

/**
 * Created by student on 2015/04/25.
 */

public class BusFactory {

    public static Bus createBus(Map<String, String> values)
    {
        Bus bus= new Bus
                .Builder(values.get("bus_name"))
                .from(values.get("from_location"))
                .arr_time(values.get("arrival_time"))
                .dep_time(values.get("departure_time"))
                .to(values.get("to_location"))
                .build();
        return bus;
    }



}
