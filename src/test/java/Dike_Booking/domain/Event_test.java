package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Event_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testEvent() throws Exception {
        Event event = new Event.Builder("Music").name("Music").build();
        Assert.assertEquals("Music", event.getEvent_name());

    }
}
