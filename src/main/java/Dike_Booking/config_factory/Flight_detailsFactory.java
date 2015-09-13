package Dike_Booking.config_factory;

import Dike_Booking.domain.Flight_details;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class Flight_detailsFactory {
    public static Integer flight_id;
    public static Flight_details createFlightDetails(int price,int seats_aval,Map<String, String> values)
    {
        Flight_details details = new  Flight_details
                .Builder(flight_id)
                .flight_date(values.get("flight_date"))
                .price(price)
                .seat_aval(seats_aval)
                .build();

        return details;
    }
}
