package Dike_Booking.config_factory;

import Dike_Booking.domain.Flight;

import java.util.Map;

/**
 * Created by student on 2015/04/25.
 */
public class FilghtFactory {
    public static Integer flight_id;
    public static Flight createFlight( Map<String, String> values)
    {
        Flight flight= new Flight
                .Builder(flight_id)
                .from(values.get("from_location"))
                .to(values.get("to_location"))
                .dep_time(values.get("departure_time"))
                .arr_time(values.get("arrival_time"))
                .build();
        return flight;
    }
}
