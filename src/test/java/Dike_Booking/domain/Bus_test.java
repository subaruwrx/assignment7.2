package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Bus_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testbus() throws Exception {
        Bus bus = new Bus.Builder("cape town").from("cape town").build();
        Assert.assertEquals("cape town", bus.getFrom_location());

    }
}
