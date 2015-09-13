package Dike_Booking.api;

import Dike_Booking.Service.BusDetail_Service;
import Dike_Booking.Service.FlightDetails_Service;
import Dike_Booking.domain.Bus_details;
import Dike_Booking.domain.Flight_details;
import Dike_Booking.model.Bus_detailsResource;
import Dike_Booking.model.Flight_detailResource;
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
@RequestMapping(value="/FlightDetails/**")
public class Flight_DetailsPage {

    @Autowired
    private FlightDetails_Service service;

    @RequestMapping(value = "/FlightDetails", method = RequestMethod.GET)

    public List<Flight_detailResource> getFlightDetails() {
        List<Flight_detailResource> hateos = new ArrayList<>();
        List<Flight_details> flightdetails = service.getFlightDetails();
        for (Flight_details flight : flightdetails) {
            Flight_detailResource res = new Flight_detailResource
                    .Builder(flight.getFlight_id())
                    .flight_date(flight.getFlight_date())
                    .price(flight.getprice())
                    .seat_aval(flight.getSeats_aval())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
