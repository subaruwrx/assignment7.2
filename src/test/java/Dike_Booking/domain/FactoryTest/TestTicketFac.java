package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.TicketFactory;
import Dike_Booking.domain.Ticket_info;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class TestTicketFac {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreatedProfile() throws Exception {

        Map<String, String> values = new HashMap<String, String>();


        values.put("event_date", "24 may 2016");
        values.put("status","available");



       Ticket_info info = TicketFactory
                .createTicket(values);

        Assert.assertEquals("24 may 2016", info.getEvent_date());
       // Assert.assertEquals(101, info.getTick_num());
    }

    @Test
    public void testUpdateProfile() throws Exception {

        Map<String, String> values = new HashMap<String, String>();

        values.put("event_date", "24 may 2016");
        values.put("status","available");



        Ticket_info info = TicketFactory
                .createTicket(values);



        Ticket_info info1 = new   Ticket_info
                .Builder(info.getTick_num())
                .copy(info)
                .event_date("25 may 2016")
                .build();
        //Assert.assertEquals(101, info.getTick_num());
        Assert.assertEquals("25 may 2016", info1.getEvent_date());
        Assert.assertEquals("24 may 2016", info.getEvent_date());



    }
}
