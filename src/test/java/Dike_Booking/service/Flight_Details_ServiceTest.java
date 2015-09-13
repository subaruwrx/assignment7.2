package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.FlightDetails_Service;
import Dike_Booking.Service.Flight_Service;
import Dike_Booking.config_factory.Flight_detailsFactory;
import Dike_Booking.domain.Flight;
import Dike_Booking.domain.Flight_details;
import Dike_Booking.repository.Flight_d_Repository;
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
public class Flight_Details_ServiceTest extends AbstractTestNGSpringContextTests {
    private Integer flight_id;

    @Autowired
    private FlightDetails_Service service;

    @Autowired
    public Flight_d_Repository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("flight_date","12/jan/2015");




        Flight_details flight = Flight_detailsFactory
                .createFlightDetails(500, 100, values);

        repo.save(flight);
        flight_id = flight.getFlight_id();
        Assert.assertNotNull(flight.getFlight_id());
    }
    @Test
    public void testFlightDetails() throws Exception {

        List<Flight_details> flight=service.getFlightDetails();
        org.testng.Assert.assertTrue(flight.size() == 2);

    }
}
