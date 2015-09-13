package Dike_Booking.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by student on 2015/04/18.
 */
public class Credit_card_test {
    public void setUp() throws Exception {


    }

    @Test
    public void testInfo() throws Exception {
        Credit_card_details  details= new Credit_card_details.Builder(8).card_holder("Sibabalwe").build();
        Assert.assertEquals("Sibabalwe", details.getCardholder());

    }
}
