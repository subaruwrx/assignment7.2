package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.SportService;
import Dike_Booking.config_factory.SportFactory;
import Dike_Booking.domain.Music;
import Dike_Booking.domain.Sport;
import Dike_Booking.repository.SportRepository;
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
public class Sport_Service_Test extends AbstractTestNGSpringContextTests {
    private Integer sport_id;
    @Autowired
    private SportService service;
    @Autowired
    private SportRepository repo;

    @Test
    public void create() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("sport_type","Rugby");
        values.put("team","All blacks vs South africa");



        Sport sport = SportFactory
                .createSport(values);

        repo.save(sport);
        sport_id = sport.getSport_id();
        Assert.assertNotNull(sport.getSport_id());
    }
    @Test
    public void testEventinfo() throws Exception {

        List<Sport> sport = service.getSport();
        Assert.assertTrue(sport.size() == 2);
    }

}
