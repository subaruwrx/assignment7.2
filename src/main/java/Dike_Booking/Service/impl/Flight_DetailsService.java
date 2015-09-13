package Dike_Booking.Service.impl;

import Dike_Booking.Service.FlightDetails_Service;
import Dike_Booking.domain.Flight_details;
import Dike_Booking.repository.EventRepository;
import Dike_Booking.repository.Flight_d_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class Flight_DetailsService implements FlightDetails_Service {
    @Autowired
    Flight_d_Repository repository;
    public List<Flight_details> getFlightDetails() {
        List<Flight_details> allFlights=new ArrayList<Flight_details>();

        Iterable<Flight_details> flightsD = repository.findAll();
        for(Flight_details flight_detail: flightsD)
        {
            allFlights.add(flight_detail);
        }
        return allFlights;
    }
}
