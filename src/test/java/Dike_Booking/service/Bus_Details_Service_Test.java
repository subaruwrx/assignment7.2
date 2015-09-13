package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.BusDetail_Service;
import Dike_Booking.Service.Bus_Service;
import Dike_Booking.config_factory.Bus_detailsFactory;
import Dike_Booking.domain.Bus;
import Dike_Booking.domain.Bus_details;
import Dike_Booking.repository.Bus_d_Repository;
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
 * Created by student on 2015/05/21.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class Bus_Details_Service_Test extends AbstractTestNGSpringContextTests {
    private Integer trip_id;

    @Autowired
    private BusDetail_Service service;
    @Autowired
    public Bus_d_Repository repo;

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
    @Test
    public void testGetBus() throws Exception {

        List<Bus_details> bus = service.getBusDetails();
        Assert.assertTrue(bus.size() == 1);
    }
}
