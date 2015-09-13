package Dike_Booking.Service.impl;

import Dike_Booking.Service.Flight_Service;
import Dike_Booking.domain.Flight;
import Dike_Booking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class FlightServiceImp implements Flight_Service {
    @Autowired
    FlightRepository repository;
    public List<Flight> getFlights()
    {
        List<Flight> allFlights=new ArrayList<Flight>();

        Iterable<Flight> flights = repository.findAll();
        for(Flight flight: flights)
        {
            allFlights.add(flight);
        }
        return allFlights;
    }
}
