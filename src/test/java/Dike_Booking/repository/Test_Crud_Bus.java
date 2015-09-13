package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.BusFactory;
import Dike_Booking.domain.Bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
public class Test_Crud_Bus extends AbstractTestNGSpringContextTests {
    private Integer trip_id;


    @Autowired
    public  BusRepository repo;

    public Test_Crud_Bus() {
    }


        @Test
        public void create() throws Exception {

            Map<String, String> values = new HashMap<String, String>();
            values.put("bus_name", "Inter Cape");
            values.put("from_location", "Port elizabeth");
            values.put("to_location", "Cape town");
            values.put("departure_time", "8:00");
            values.put("arrival_time", "15:00");


            Bus bus = BusFactory
                    .createBus(values);

            repo.save(bus);
            trip_id = bus.getTrip_id();
            Assert.assertNotNull(trip_id);
        }

    @Test(dependsOnMethods = "create")
    //@org.junit.Test
    public void read() throws Exception {
        Bus bus = repo.findOne(trip_id);
        Assert.assertNotNull(bus);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Bus bus = repo.findOne(trip_id);

        Bus newBus = new Bus
                .Builder(bus.getbus_name())
                .copy(bus)
                .trip_id(bus.getTrip_id())
                .from(bus.getFrom_location())
                .arr_time("16:00")
                .dep_time(bus.getDeparture_time())
                .to(bus.getTo_location())
                .build();

        repo.save(newBus);

        Bus updateBus = repo.findOne(trip_id);
        Assert.assertEquals(updateBus.getArrival_time(),"16:00");
    }

    @Test(dependsOnMethods = "update")
    //@org.junit.Test
    public void delete() throws Exception {
        Bus bus = repo.findOne(trip_id);
        repo.delete(bus);
        Bus deletedBus = repo.findOne(trip_id);
        Assert.assertNull(deletedBus);

    }

}
