package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.FilghtFactory;
import Dike_Booking.domain.Flight;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class Test_filght_fac {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateFlight() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("from_location", "Cape Town");
        values.put("to_location","PE");
        values.put("departure_time","14:30");
        values.put("arrival_time","12:00");

       Flight flight = FilghtFactory
                .createFlight(values);

        Assert.assertEquals("PE", flight.getTo_location());
    }

    @Test
    public void testUpdateFlight() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("from_location", "Cape Town");
        values.put("to_location","PE");
        values.put("departure_time","14:30");
        values.put("arrival_time","12:00");

       Flight flight = FilghtFactory
                .createFlight(values);

        Flight flight1= new Flight
                .Builder(5)
                .copy(flight)
                .build();
        Assert.assertEquals("Cape Town",flight1.getFrom_location());
        Assert.assertEquals("PE",flight1.getTo_location());
        Assert.assertEquals("14:30",flight1.getDeparture_time());
        Assert.assertEquals("12:00",flight1.getArrival_time());
        //Assert.assertEquals(2,flight1.getFlight_id());
        //Assert.assertEquals(5,flight.getFlight_id());











    }
}
