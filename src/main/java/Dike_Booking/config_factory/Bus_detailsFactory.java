package Dike_Booking.config_factory;

import Dike_Booking.domain.Bus_details;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class Bus_detailsFactory {
    public static Integer trip_id;
    public static int seats_aval;
    public static int  price;


    public static Bus_details createbusDetails(Map<String, String> values)
    {
        Bus_details details = new  Bus_details
                .Builder(values.get("bus_name"))
                .trip_id(trip_id)
                .trip_date(values.get("trip_date"))
                .price(price)
                .seat_aval(seats_aval)
                .build();

        return details;
    }

}
