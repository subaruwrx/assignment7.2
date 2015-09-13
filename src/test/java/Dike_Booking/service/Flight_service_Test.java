package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.Event_Service;
import Dike_Booking.Service.Flight_Service;
import Dike_Booking.config_factory.FilghtFactory;
import Dike_Booking.domain.Flight;
import Dike_Booking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class Flight_service_Test extends AbstractTestNGSpringContextTests {

    private Integer flight_id;
    @Autowired
    private Flight_Service service;

    @Autowired
    public FlightRepository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("from_location","Port elizabeth");
        values.put("to_location","Cape town");
        values.put("departure_time","8:00");
        values.put("arrival_time","15:00");



        Flight flight = FilghtFactory
                .createFlight(values);

        repo.save(flight);
        flight_id = flight.getFlight_id();
        Assert.assertNotNull(flight.getFlight_id());
    }
    @Test
    public void testEventinfo() throws Exception {

        List<Flight> flight=service.getFlights();
        org.testng.Assert.assertTrue(flight.size() == 2);

    }
}
