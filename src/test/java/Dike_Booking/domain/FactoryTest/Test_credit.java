package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.CreditFactory;
import Dike_Booking.domain.Credit_card_details;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class Test_credit {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateCard() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("card_holder", "sibabalwe");
        values.put("card_type","Master card");
        values.put("expiration_month","march");
        values.put("expiration_year","2016");

        Credit_card_details card = CreditFactory
                .createCredit(values);

        Assert.assertEquals("sibabalwe",card.getCardholder() );
    }

    @Test
    public void testUpdateCard() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("card_holder", "sibabalwe");
        values.put("card_type","Master card");
        values.put("expiration_month","march");
        values.put("expiration_year","2016");

        Credit_card_details card = CreditFactory
                .createCredit(values);

        Credit_card_details card1= new Credit_card_details
                .Builder(8909)
                .copy(card)
                .build();
        Assert.assertEquals("sibabalwe", card1.getCardholder());
        Assert.assertEquals("Master card",card1.getCard_type());
        Assert.assertEquals("march",card1.getMonth());
        Assert.assertEquals("2016",card1.getYear());
        //ssert.assertEquals(3899,card.getCard_num());












    }

}
