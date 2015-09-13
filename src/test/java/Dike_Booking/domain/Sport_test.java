package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Sport_test {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testEvent() throws Exception {
        Sport sport = new Sport.Builder("Chiefs").team("Chiefs").build();
        Assert.assertEquals("Chiefs", sport.getTeam());

    }
}
