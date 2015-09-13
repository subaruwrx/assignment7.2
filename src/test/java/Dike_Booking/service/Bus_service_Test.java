package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.Bus_Service;
import Dike_Booking.config_factory.BusFactory;
import Dike_Booking.domain.Bus;
import Dike_Booking.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class Bus_service_Test extends AbstractTestNGSpringContextTests {

    private Integer trip_id;
    @Autowired
    private Bus_Service service;

    @Autowired
    public  BusRepository repo;

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

    @Test
    public void testGetBus() throws Exception {

       List<Bus> bus=service.getBusses();
        Assert.assertTrue(bus.size() == 1);

    }

}
