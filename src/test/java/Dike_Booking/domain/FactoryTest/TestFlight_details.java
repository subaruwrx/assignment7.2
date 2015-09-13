package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.Flight_detailsFactory;
import Dike_Booking.domain.Flight_details;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class TestFlight_details {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreatedFlightdetails() throws Exception {

        Map<String, String> values = new HashMap<String, String>();


        values.put("flight_date", "24 june 2015");


        Flight_details details = Flight_detailsFactory
                .createFlightDetails(800, 60, values);

        Assert.assertEquals("24 june 2015", details.getFlight_date());
       // Assert.assertEquals(101, details.getFlight_id());
    }

    @Test
    public void testUpdateFlightDetails() throws Exception {

        Map<String, String> values = new HashMap<String, String>();


        values.put("flight_date", "25 june 2015");


        Flight_details details = Flight_detailsFactory
                .createFlightDetails(800, 60, values);


        Flight_details details1 = new Flight_details
                .Builder(details.getFlight_id())
                .copy(details)
                .flight_date(details.getFlight_date())
                .price(500)
                .seat_aval(61)
                .build();
       // Assert.assertEquals(fli, details1.getFlight_id());
        Assert.assertEquals("25 june 2015", details1.getFlight_date());
        Assert.assertEquals(500, details1.getprice());
        Assert.assertEquals(800, details.getprice());
        Assert.assertEquals(61, details1.getSeats_aval());
        Assert.assertEquals(60, details.getSeats_aval());
    }
}