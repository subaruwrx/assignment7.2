package Dike_Booking;

import Dike_Booking.config_factory.CreditFactory;
import Dike_Booking.domain.Credit_card_details;
import Dike_Booking.repository.CardRepository;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    private Integer card_num;

    @Autowired
    private CardRepository repo;

    @org.testng.annotations.Test
    public void testCreate() throws Exception {
        //
        // List<Music> musicList = new ArrayList<Music>();
        Map<String,String> values = new HashMap<String,String>();
        values.put("card_holder","Sibabalwe Dike");
        values.put("card_type","MasterCard");
        values.put("expiration_month","May");
        values.put("expiration_year","2016");


        Credit_card_details card = CreditFactory
                .createCredit( values);

        repo.save(card);
        card_num = card.getCard_num();
        Assert.assertNotNull(card.getCard_num());
    }
}
