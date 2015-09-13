package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Flight_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testbus() throws Exception {
        Flight flight = new Flight.Builder(5).from("cape town").build();
        Assert.assertEquals("cape town", flight.getFrom_location());

    }

}
