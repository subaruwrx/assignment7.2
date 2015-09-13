package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.BusFactory;
import Dike_Booking.config_factory.FilghtFactory;
import Dike_Booking.domain.Bus;
import Dike_Booking.domain.Flight;
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
public class Test_Crud_Flight  extends AbstractTestNGSpringContextTests {

    private Integer flight_id;

    @Autowired
    public  FlightRepository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("from_location","Port elizabeth");
        values.put("to_location","Cape town");
        values.put("departure_time","8:00");
        values.put("arrival_time","15:00");



       Flight flight = FilghtFactory
                .createFlight(values);

        repo.save(flight);
        flight_id = flight.getFlight_id();
        Assert.assertNotNull(flight.getFlight_id());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
       Flight flight = repo.findOne(flight_id);
        Assert.assertNotNull(flight);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Flight flight = repo.findOne(flight_id);

        Flight newflight = new Flight
                .Builder(flight_id)
                .copy(flight)
                .from(flight.getFrom_location())
                .to(flight.getTo_location())
                .dep_time("12:00")
                .arr_time(flight.getArrival_time())
                .build();

        repo.save(newflight);

        Flight updateFlight = repo.findOne(flight_id);
        Assert.assertEquals(updateFlight.getDeparture_time(),"12:00");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Flight flight = repo.findOne(flight_id);
        repo.delete(flight);
        Flight deletedFlight  = repo.findOne(flight_id);
        Assert.assertNull(deletedFlight);

    }
}
