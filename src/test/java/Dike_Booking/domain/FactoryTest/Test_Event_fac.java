package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.EventFactory;
import Dike_Booking.domain.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/25.
 */
public class Test_Event_fac {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateEvent() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("event_type","Music");
        values.put("event_name","makufe");
        values.put("place","the LAB");
        values.put("date","12/Jan/2016");

        Event event = EventFactory
                .createEvents(10, values);

        Assert.assertEquals("Music", event.getEvent_type());
    }

    @Test
    public void testUpadteEvent() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("event_type","Music");
        values.put("event_name","makufe");
        values.put("place","the LAB");
        values.put("date","12/Jan/2016");

        Event event = EventFactory
                .createEvents(10, values);

        Event event1= new Event
                .Builder(event.getEvent_type())
                .copy(event)
                .build();
        Assert.assertEquals("Music",event1.getEvent_type());
        Assert.assertEquals("makufe",event1.getEvent_name());






    }
}
