package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.ProfileFactory;
import Dike_Booking.config_factory.TicketFactory;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.domain.User_profile;
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
public class Test_Crud_Ticket extends AbstractTestNGSpringContextTests {
    private Integer ticknum;

    @Autowired
    public  TicketRepository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("event_date","12/Jan/2017");
        values.put("status","available");




        Ticket_info info= TicketFactory
                .createTicket(values);

        repo.save(info);
        ticknum= info.getTick_num();
        Assert.assertNotNull(info.getTick_num());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Ticket_info info = repo.findOne(ticknum);
        Assert.assertNotNull(info);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Ticket_info info = repo.findOne(ticknum);

        Ticket_info newInfo = new  Ticket_info
                .Builder(info.getTick_num())
                .copy(info)
                .event_date(info.getEvent_date())
                .status("not available")
                .build();

        repo.save(newInfo);

        Ticket_info updateInfo = repo.findOne(ticknum);
        Assert.assertEquals(updateInfo.getStatus(),"not available");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Ticket_info info = repo.findOne(ticknum);
        repo.delete(info);
        Ticket_info deletedInfo   = repo.findOne(ticknum);
        Assert.assertNull(deletedInfo);

    }
}
