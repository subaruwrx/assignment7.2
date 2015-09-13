package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Bus_details_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testInfo() throws Exception {
        Bus_details  details= new Bus_details.Builder("intercape").seat_aval(50).build();
        Assert.assertEquals(50, details.getSeats_aval());

    }
}
