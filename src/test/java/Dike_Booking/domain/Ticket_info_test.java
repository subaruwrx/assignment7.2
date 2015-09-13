package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Ticket_info_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testInfo() throws Exception {
        Ticket_info  info = new Ticket_info .Builder(100).event_date("29/04/2015").build();
        Assert.assertEquals("29/04/2015",info.getEvent_date());

    }
}
