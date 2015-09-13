package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Flight_detail_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testInfo() throws Exception {
        Flight_details  details= new Flight_details.Builder(1).seat_aval(500).build();
        Assert.assertEquals(500, details.getSeats_aval());

    }
}
