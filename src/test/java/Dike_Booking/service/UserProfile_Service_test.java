package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.Ticket_Service;
import Dike_Booking.Service.UserProfile_Service;
import Dike_Booking.config_factory.ProfileFactory;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.domain.User_profile;
import Dike_Booking.repository.UserRepository;
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
public class UserProfile_Service_test extends AbstractTestNGSpringContextTests {
    private Integer user_id;

    @Autowired
    private UserProfile_Service service;
    @Autowired
    public UserRepository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Peter");
        values.put("surname","Dike");
        values.put("address","33 cape town");
        values.put("email","siba@gmail.com");
        values.put("tel_no","0835670001");
        values.put("password","12345");



        User_profile profile = ProfileFactory
                .createProfile(values);

        repo.save(profile);
        user_id= profile.getUser_id();
        Assert.assertNotNull(profile.getUser_id());
    }
    @Test
    public void testUserProfileinfo() throws Exception {

        List<User_profile> info = service.getUserInfo();
        Assert.assertTrue(info.size() == 2);
    }
}
