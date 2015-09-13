package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.Event_Service;
import Dike_Booking.config_factory.EventFactory;
import Dike_Booking.domain.Event;
import Dike_Booking.repository.EventRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class Event_service_Test extends AbstractTestNGSpringContextTests {
    private Long event_id;
    @Autowired
    private Event_Service service;

    @Autowired
    private EventRepository repo;

    @Test
    public void create() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("event_type","Music");
        values.put("event_name","makufe");
        values.put("place","the LAB");
        values.put("date","12/Jan/2016");



        Event event = EventFactory
                .createEvents(10, values);

        repo.save(event);
        event_id = event.getEvent_id();
        Assert.assertNotNull(event.getEvent_id());
    }
    @Test
    public void testEventinfo() throws Exception {

        List<Event> event=service.getEvents();
        org.testng.Assert.assertTrue(event.size() == 3);

    }

}
