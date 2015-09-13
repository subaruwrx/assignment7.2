package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.Bus_detailsFactory;
import Dike_Booking.domain.Bus_details;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class Test_bus_details {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateCard() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("bus_name", "Grey Hound");
        values.put("trip_date","12 march 2015");


        //Bus_details bus = Bus_detailsFactory
              //  .createbusDetails(65, 500, values);

       // Assert.assertEquals(65, bus.getSeats_aval());
        //Assert.assertEquals(500, bus.getPrice());
    }

    @Test
    public void testUpdateCard() throws Exception {

        Map<String,String> values = new HashMap<String,String>();



        values.put("bus_name", "Grey Hound");
        values.put("trip_date","12 march 2015");

/*
        Bus_details bus = Bus_detailsFactory
                .createbusDetails(65, 500, values);

        Bus_details bus1= new  Bus_details
                .Builder(bus.getBus_name())
                .copy(bus)
                .build();
        Assert.assertEquals("Grey Hound",bus1.getBus_name() );
        Assert.assertEquals("12 march 2015",bus1.getTrip_date());
        Assert.assertEquals(65,bus1.getSeats_aval());
        Assert.assertEquals(500,bus1.getPrice());
        Assert.assertEquals(50,bus.getSeats_aval());
        Assert.assertEquals(400,bus.getPrice());

*/










    }
}
