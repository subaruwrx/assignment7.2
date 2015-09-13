package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.BusFactory;
import Dike_Booking.domain.Bus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/25.
 */
public class Bus_fac_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateEvent() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("bus_name","Inter Cape");
        values.put("from_location","Port elizabeth");
        values.put("to_location","Cape town");
        values.put("departure_time","8:00");
        values.put("arrival_time","15:00");

        Bus bus = BusFactory
                .createBus(values);

        Assert.assertEquals("Inter Cape", bus.getbus_name());
    }

    @Test
    public void testUpadteEvent() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("bus_name","Inter Cape");
        values.put("from_location","Port elizabeth");
        values.put("to_location","Cape town");
        values.put("departure_time","8:00");
        values.put("arrival_time","15:00");

        Bus bus = BusFactory
                .createBus(values);


        Bus bus1= new Bus
                .Builder(bus.getbus_name())
                .copy(bus)
                .build();
        //Assert.assertEquals("sport",event1.getEvent_type());
        //Assert.assertEquals("Rugby",event1.getEvent_name());






    }
}
