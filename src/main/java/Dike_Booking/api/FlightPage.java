package Dike_Booking.api;

import Dike_Booking.Service.Bus_Service;
import Dike_Booking.Service.Flight_Service;
import Dike_Booking.domain.Bus;
import Dike_Booking.domain.Flight;
import Dike_Booking.model.BusResource;
import Dike_Booking.model.FlightResource;
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
@RequestMapping(value="/Flight/**")
public class FlightPage {
    @Autowired
    private Flight_Service service;

    @RequestMapping(value = "/Flight", method = RequestMethod.GET)

    public List<FlightResource> getFlight() {
        List<FlightResource> hateos = new ArrayList<>();
        List<Flight> flightname = service.getFlights();
        for (Flight flight : flightname) {
            FlightResource res = new FlightResource
                    .Builder(flight.getFlight_id())
                    .from(flight.getFrom_location())
                    .to(flight.getTo_location())
                    .dep_time(flight.getDeparture_time())
                    .arr_time(flight.getArrival_time())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }

}
