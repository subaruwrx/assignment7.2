package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Music_test {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testInfo() throws Exception {
        Music   music= new Music.Builder("House").artist("black coffee").build();
        Assert.assertEquals("black coffee", music.getArtist());

    }
}
