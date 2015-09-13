package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.SportFactory;
import Dike_Booking.domain.Sport;
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
public class Test_Crud_Sport extends AbstractTestNGSpringContextTests {
    private Integer sport_id;

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

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Sport sport= repo.findOne(sport_id);
        Assert.assertNotNull(sport);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Sport sport = repo.findOne(sport_id);

        Sport newSport  = new Sport
                .Builder(sport.getSport_type())
                .copy(sport)
                .team("Whales")
                .sport_id(sport_id)
                .build();

        repo.save(newSport);

        Sport  updateSport = repo.findOne(sport_id);
        Assert.assertEquals(updateSport.getTeam(),"Whales");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Sport sport = repo.findOne(sport_id);
        repo.delete(sport);
        Sport deletedSport = repo.findOne(sport_id);
        org.testng.Assert.assertNull(deletedSport);

    }
}
