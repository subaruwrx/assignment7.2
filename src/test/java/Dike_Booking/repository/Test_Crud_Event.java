package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.EventFactory;
import Dike_Booking.domain.Event;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/12.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class Test_Crud_Event extends AbstractTestNGSpringContextTests {

    private Long event_id;

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
               .createEvents(10,values);

        repo.save(event);
        event_id = event.getEvent_id();
        Assert.assertNotNull(event.getEvent_id());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Event event = repo.findOne(event_id);
        Assert.assertNotNull(event);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Event event  = repo.findOne(event_id);

        Event newEvent  = new Event
                .Builder(event.getEvent_type())
                .copy(event)
                .name(event.getEvent_name())
                .event_id(event_id)
                .place(event.getPlace())
                .price(500)
                .date(event.getDate())
                .build();

        repo.save(newEvent);

        Event updateEvent = repo.findOne(event_id);
        org.testng.Assert.assertEquals(updateEvent.getPrice(), 500);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Event event = repo.findOne(event_id);
        repo.delete(event);
        Event deletedEvent = repo.findOne(event_id);
        Assert.assertNull(deletedEvent);

    }

}
