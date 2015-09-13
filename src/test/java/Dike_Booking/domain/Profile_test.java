package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Profile_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testProfile() throws Exception {
        User_profile profile = new User_profile.Builder(89).surname("Dike").build();
        Assert.assertEquals("Dike", profile.getSurname());

    }
}
