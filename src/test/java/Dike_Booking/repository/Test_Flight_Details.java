package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.FilghtFactory;
import Dike_Booking.config_factory.Flight_detailsFactory;
import Dike_Booking.domain.Flight;
import Dike_Booking.domain.Flight_details;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/14.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class Test_Flight_Details extends AbstractTestNGSpringContextTests {
    private Integer flight_id;

    @Autowired
    public  Flight_d_Repository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("flight_date","12/jan/2015");




        Flight_details flight = Flight_detailsFactory
                .createFlightDetails(500,100,values);

        repo.save(flight);
        flight_id = flight.getFlight_id();
        Assert.assertNotNull(flight.getFlight_id());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Flight_details flight = repo.findOne(flight_id);
        org.testng.Assert.assertNotNull(flight);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Flight_details flight = repo.findOne(flight_id);

        Flight_details newflight = new Flight_details
                .Builder(flight.getFlight_id())
                .copy(flight)
                .flight_date(flight.getFlight_date())
                .price(8800)
                .seat_aval(87)
                .build();

        repo.save(newflight);

        Flight_details updateFilght = repo.findOne(flight_id);
        Assert.assertEquals(updateFilght.getprice(),8800);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Flight_details flight = repo.findOne(flight_id);
        repo.delete(flight);
        Flight_details deletedFlight  = repo.findOne(flight_id);
        Assert.assertNull(deletedFlight);

    }
}
