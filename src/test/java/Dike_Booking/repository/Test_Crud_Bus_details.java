package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.Bus_detailsFactory;
import Dike_Booking.domain.Bus_details;
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
public class Test_Crud_Bus_details  extends AbstractTestNGSpringContextTests {

    private Integer trip_id;

    @Autowired
    public  Bus_d_Repository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("bus_name","Inter Cape");
        values.put("trip_date","25/Jun/2015");




       Bus_details bus = Bus_detailsFactory
                .createbusDetails(values);

        repo.save(bus);
        trip_id= bus.getTrip_id();
        Assert.assertNotNull(bus.getTrip_id());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Bus_details bus = repo.findOne(trip_id);
        org.testng.Assert.assertNotNull(bus);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Bus_details bus= repo.findOne(trip_id);

        Bus_details newBus = new Bus_details
                .Builder("Translux")
                .copy(bus)
                .trip_date(bus.getTrip_date())
                .price(500)
                .seat_aval(45)
                .build();

        repo.save(newBus);

        Bus_details updateBus = repo.findOne(trip_id);
        Assert.assertEquals(updateBus.getPrice(),500);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Bus_details bus = repo.findOne(trip_id);
        repo.delete(bus);
        Bus_details deletedBus = repo.findOne(trip_id);
        Assert.assertNull(deletedBus);

    }
}
