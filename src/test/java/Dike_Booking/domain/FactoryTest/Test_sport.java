package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.SportFactory;
import Dike_Booking.domain.Sport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class Test_sport {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreatedSport() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("sport_type","Rugby");
        values.put("team","All blacks vs South africa");




        Sport sport = SportFactory
                .createSport(values);

        Assert.assertEquals("All blacks vs South africa", sport.getTeam());
        //Assert.assertEquals(1, sport.getSport_id());
    }

    @Test
    public void testUpdateSport() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("sport_type","Rugby");
        values.put("team","All blacks vs South africa");


        Sport sport = SportFactory
                .createSport(values);

        Assert.assertEquals("All blacks vs South africa", sport.getTeam());
        //Assert.assertEquals(2, sport.getSport_id());

        Sport sport1= new  Sport
                .Builder(sport.getSport_type())
                .copy(sport)
                .sport_id(2)
                .build();
        Assert.assertEquals("All blacks vs South africa",sport1.getTeam() );
        Assert.assertEquals("Rugby",sport1.getSport_type());
        //Assert.assertEquals(2, sport1.getSport_id());

        //Assert.assertEquals(3, sport.getSport_id());















    }
}
