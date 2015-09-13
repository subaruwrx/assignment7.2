package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.SportService;
import Dike_Booking.Service.Ticket_Service;
import Dike_Booking.config_factory.TicketFactory;
import Dike_Booking.domain.Sport;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.repository.TicketRepository;
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
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class Ticket_Service_test extends AbstractTestNGSpringContextTests {

    private Integer ticknum;

    @Autowired
    private Ticket_Service service;
    @Autowired
    public TicketRepository repo;

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
    @Test
    public void testTicketinfo() throws Exception {

        List<Ticket_info> info = service.getTickets();
        Assert.assertTrue(info.size() == 2);
    }
}
